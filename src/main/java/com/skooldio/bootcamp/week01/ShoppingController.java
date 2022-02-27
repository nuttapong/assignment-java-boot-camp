package com.skooldio.bootcamp.week01;

import com.skooldio.bootcamp.week01.entity.*;
import com.skooldio.bootcamp.week01.responsepojo.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShoppingController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/api/search/{title}")
    public List<ProductResponse> searchProductByTitle(@PathVariable String title){
        List<Product> productList = productService.findProductByTitle(title);
        List<ProductResponse> responseList = productList.stream().map(this::convertToProductResponse).collect(Collectors.toList());
        return responseList;
    }

    @GetMapping("/api/get_product/{id}")
    public ProductDetailResponse searchProductByTitle(@PathVariable int id){
        Product product = productService.findProductById(id);
        List<ProductAvailable> productAvailableList = productService.getProductAvailables(product);
        return convertToProductDetailResponse(product, productAvailableList);
    }

    @GetMapping("/api/userinfo/{username}")
    public UserResponse getUserInfo(@PathVariable String username){
        User user = userService.getUserInfoByUsername(username);
        return convertToUserResponse(user);
    }

    @GetMapping("/api/shipping_address/{username}")
    public List<ShippingAddressResponse> getShippingAddress(@PathVariable String username){
        List<ShippingAddress> shippingAddressList = userService.getShippingAddress(username);
        List<ShippingAddressResponse> responseList = shippingAddressList.stream().map(this::convertToShippingAddressResponse).collect(
                Collectors.toList());
        return responseList;
    }

    @GetMapping("/api/cart_detail/{username}")
    public List<ShoppingCartDetailResponse> getShoppingCartDetail(@PathVariable String username){
        User user = userService.getUserInfoByUsername(username);
        List<ShoppingCart> shoppingCartList = shoppingCartService.getShoppingCartByUser(user);
        List<ShoppingCartDetailResponse> shoppingCartDetailResponseList = new LinkedList<ShoppingCartDetailResponse>();
        for(ShoppingCart shoppingCart : shoppingCartList){
            ShoppingCartDetailResponse shoppingCartDetailResponse = convertShoppingCartToResponse(shoppingCart);
            shoppingCartDetailResponseList.add(shoppingCartDetailResponse);
        }
        return shoppingCartDetailResponseList;
    }

    @PostMapping("/api/add_to_cart")
    public ShoppingCartDetailResponse addProductToCart(@RequestBody ShoppingCartAddRequest shoppingCartAddRequest){
        if(shoppingCartAddRequest != null){

            int productAvailableId = shoppingCartAddRequest.getProductAvailableId();
            ProductAvailable productAvailable = productService.findProductAvailableById(productAvailableId);

            String username = shoppingCartAddRequest.getUsername();
            User user = userService.getUserInfoByUsername(username);

            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setProductAvailable(productAvailable);
            shoppingCart.setUser(user);
            shoppingCart.setQuantity(shoppingCartAddRequest.getQuantity());
            shoppingCart = shoppingCartService.addProductToShoppingCart(shoppingCart);

            return convertShoppingCartToResponse(shoppingCart);
        }
        return null;
    }

    //##################### Model Mapper convertor #####################
    private ProductResponse convertToProductResponse(Product product){
        return modelMapper.map(product, ProductResponse.class);
    }

    private ProductDetailResponse convertToProductDetailResponse(Product product, List<ProductAvailable> productAvailableList){
        ProductDetailResponse productDetailResponse = modelMapper.map(product, ProductDetailResponse.class);
        List<ProductAvailableResponse> availableList = productAvailableList.stream().map(this::convertToProductAvailableResponse).collect(
                Collectors.toList());
        productDetailResponse.setProductAvailableResponseList(availableList);
        return productDetailResponse;
    }

    private ProductAvailableResponse convertToProductAvailableResponse(ProductAvailable productAvailable){
        return modelMapper.map(productAvailable, ProductAvailableResponse.class);
    }

    private UserResponse convertToUserResponse(User user){
        return modelMapper.map(user, UserResponse.class);
    }

    private ShippingAddressResponse convertToShippingAddressResponse(ShippingAddress shippingAddress){
        return modelMapper.map(shippingAddress, ShippingAddressResponse.class);
    }

    private ShoppingCartDetailResponse convertShoppingCartToResponse(ShoppingCart shoppingCart) {
        ShoppingCartDetailResponse shoppingCartDetailResponse = new ShoppingCartDetailResponse();
        shoppingCartDetailResponse.setProductInCartId(shoppingCart.getId());
        shoppingCartDetailResponse.setDescription(shoppingCart.getProductAvailable().getProduct().getDescription());
        shoppingCartDetailResponse.setColor(shoppingCart.getProductAvailable().getProduct().getColor());
        shoppingCartDetailResponse.setSize(shoppingCart.getProductAvailable().getSize());
        shoppingCartDetailResponse.setPrice(shoppingCart.getProductAvailable().getProduct().getPrice());
        shoppingCartDetailResponse.setDiscountPercent(shoppingCart.getProductAvailable().getProduct().getDiscountPercent());
        shoppingCartDetailResponse.setDiscountPrice(shoppingCart.getProductAvailable().getProduct().getDiscountPrice());
        shoppingCartDetailResponse.setPriceIncludeVat(shoppingCart.getProductAvailable().getProduct().getDiscountPrice());
        shoppingCartDetailResponse.setThumbnailImage(shoppingCart.getProductAvailable().getProduct().getThumbnailImage());
        return shoppingCartDetailResponse;
    }
}

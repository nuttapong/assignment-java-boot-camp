package com.skooldio.bootcamp.week01;

import com.skooldio.bootcamp.week01.entity.Product;
import com.skooldio.bootcamp.week01.entity.ProductAvailable;
import com.skooldio.bootcamp.week01.entity.ShippingAddress;
import com.skooldio.bootcamp.week01.entity.User;
import com.skooldio.bootcamp.week01.responsepojo.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}

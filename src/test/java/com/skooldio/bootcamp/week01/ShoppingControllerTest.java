package com.skooldio.bootcamp.week01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skooldio.bootcamp.week01.entity.Product;
import com.skooldio.bootcamp.week01.entity.ProductAvailable;
import com.skooldio.bootcamp.week01.entity.ShippingAddress;
import com.skooldio.bootcamp.week01.entity.User;
import com.skooldio.bootcamp.week01.repo.ProductAvailableRepository;
import com.skooldio.bootcamp.week01.repo.ProductRepository;
import com.skooldio.bootcamp.week01.repo.ShippingAddressRepository;
import com.skooldio.bootcamp.week01.repo.UserRepository;
import com.skooldio.bootcamp.week01.responsepojo.ProductAvailableResponse;
import com.skooldio.bootcamp.week01.responsepojo.ProductDetailResponse;
import com.skooldio.bootcamp.week01.responsepojo.ProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShoppingControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAvailableRepository productAvailableRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;


    @Test
    void integrationTest() {

        // Initial before flow start
        initialUserInfo();
        initialProduct();

        //---------------- search product ----------------
        String searchUrl = "/api/search/CamperBeetle";
        Object[] result = testRestTemplate.getForObject(searchUrl, Object[].class);
        ObjectMapper mapper = new ObjectMapper();
        List<ProductResponse> productResponseList = mapper.convertValue(result, new TypeReference<List<ProductResponse>>() { });
        assertEquals(4, productResponseList.size());

        //---------------- get product detail ----------------
        ProductResponse productResponse = productResponseList.get(1);
        int productId = productResponse.getId();
        String getProductDetailUrl = "/api/get_product/" + productId;
        ProductDetailResponse productDetailResponse = testRestTemplate.getForObject(getProductDetailUrl, ProductDetailResponse.class);
        assertEquals("Camper Beetle Brown GORE-TEX", productDetailResponse.getProductName());

        //---------------- add to cart ----------------
        List<ProductAvailableResponse> productAvailableResponseList = productDetailResponse.getProductAvailableResponseList();
        ProductAvailableResponse productAvailableResponse = productAvailableResponseList.get(0); //select product size : EU 42 (id:4)



    }

    private void initialUserInfo() {
        User user = new User(1);
        user.setUsername("nuttapong");
        user.setRealName("ณัฐพงศ์ ด่านศิริกุล");
        user.setEmail("dansirikul@gmail.com");
        user.setPhone("0814456789");
        userRepository.save(user);

        ShippingAddress shippingAddress = new ShippingAddress(1);
        shippingAddress.setFullName("ณัฐพงศ์ ด่านศิริกุล");
        shippingAddress.setAddress("123 ซ.ประชาร่วมใจ37 ถ.ประชาร่วมใจ");
        shippingAddress.setDistrict("คลองสามวา");
        shippingAddress.setCity("Bangkok");
        shippingAddress.setPostcode("10510");
        shippingAddress.setEmail("dansirikul@gmail.com");
        shippingAddress.setPhone("0814456789");
        shippingAddress.setUser(user);
        shippingAddressRepository.save(shippingAddress);
    }


    private void initialProduct(){

        //#########################  Camper Beetle Black #########################
        Product camperBlack = new Product(1);
        camperBlack.setProductCode("001");
        camperBlack.setTitle("CamperBeetle");
        camperBlack.setProductName("Camper Beetle Black");
        camperBlack.setBrand("Camper");
        camperBlack.setDescription("CAMPER 001 รองเท้าลำลองหนัง ผู้ชาย รุ่น BEETLE สีดำ ( CAS )");
        camperBlack.setColor("Black");
        camperBlack.setPrice(7550);
        camperBlack.setDiscountPrice(6795);
        camperBlack.setDiscountPercent(10);
        camperBlack.setThumbnailImage("https://lzd-img-global.slatic.net/g/p/0e377bdcc028b58f674da793f717af2a.jpg_200x200q80.jpg_.webp");
        productRepository.save(camperBlack);

        productAvailableRepository.save(new ProductAvailable(1, "EU 41", 2, camperBlack));
        productAvailableRepository.save(new ProductAvailable(2, "EU 42", 4, camperBlack));
        productAvailableRepository.save(new ProductAvailable(3, "EU 43", 3, camperBlack));


        //#########################  Camper Beetle Brown GORE-TEX #########################
        Product camperGTexBrown = new Product(2);
        camperGTexBrown.setProductCode("002");
        camperGTexBrown.setTitle("CamperBeetle");
        camperGTexBrown.setProductName("Camper Beetle Brown GORE-TEX");
        camperGTexBrown.setBrand("Camper");
        camperGTexBrown.setDescription("CAMPER 002 รองเท้าลำลองหนัง ผู้ชาย รุ่น BEETLE GORE-TEX สีน้ำตาล ( CAS )");
        camperGTexBrown.setColor("Brown");
        camperGTexBrown.setPrice(8550);
        camperGTexBrown.setDiscountPrice(5985);
        camperGTexBrown.setDiscountPercent(30);
        camperGTexBrown.setThumbnailImage("https://lzd-img-global.slatic.net/g/p/ed496cb931c7a874e749338332a2b040.jpg_200x200q80.jpg_.webp");
        productRepository.save(camperGTexBrown);

        productAvailableRepository.save(new ProductAvailable(4, "EU 42", 3, camperGTexBrown));
        productAvailableRepository.save(new ProductAvailable(5, "EU 43", 2, camperGTexBrown));


        //####################  Camper Beetle White/Gray ####################
        Product camperWhiteGray = new Product(3);
        camperWhiteGray.setProductCode("003");
        camperWhiteGray.setTitle("CamperBeetle");
        camperWhiteGray.setProductName("Camper Beetle White/Gray");
        camperWhiteGray.setBrand("Camper");
        camperWhiteGray.setDescription("CAMPER 003 รองเท้าลำลองหนัง ผู้ชาย รุ่น BEETLE สีขาว/เทา ( CAS )");
        camperWhiteGray.setColor("White");
        camperWhiteGray.setPrice(6150);
        camperWhiteGray.setDiscountPrice(5535);
        camperWhiteGray.setDiscountPercent(10);
        camperWhiteGray.setThumbnailImage("https://lzd-img-global.slatic.net/g/p/b5b44a95e4c7d22e6f826d7f7ebe94f0.jpg_200x200q80.jpg_.webp");
        productRepository.save(camperWhiteGray);

        productAvailableRepository.save(new ProductAvailable(6, "EU 40", 2, camperWhiteGray));
        productAvailableRepository.save(new ProductAvailable(7, "EU 42", 4, camperWhiteGray));

        //####################  Camper Beetle Red ####################
        Product camperRed = new Product(4);
        camperRed.setProductCode("004");
        camperRed.setTitle("CamperBeetle");
        camperRed.setProductName("Camper Beetle Red");
        camperRed.setBrand("Camper");
        camperRed.setDescription("CAMPER 004 รองเท้าลำลองหนัง ผู้ชาย รุ่น BEETLE สีแดง ( CAS )");
        camperRed.setColor("Red");
        camperRed.setPrice(7550);
        camperRed.setDiscountPrice(4530);
        camperRed.setDiscountPercent(40);
        camperRed.setThumbnailImage("http://lzd-img-global.slatic.net/g/p/c5c75c9b0e53ae50815bb2ca8196af51.jpg_200x200q80.jpg_.webp");
        productRepository.save(camperRed);

        productAvailableRepository.save(new ProductAvailable(8, "EU 40", 2, camperRed));
        productAvailableRepository.save(new ProductAvailable(9, "EU 41", 1, camperRed));
        productAvailableRepository.save(new ProductAvailable(10, "EU 42", 2, camperRed));

    }


}
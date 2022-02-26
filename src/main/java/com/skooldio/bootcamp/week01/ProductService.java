package com.skooldio.bootcamp.week01;

import com.skooldio.bootcamp.week01.entity.Product;
import com.skooldio.bootcamp.week01.entity.ProductAvailable;
import com.skooldio.bootcamp.week01.exception.ProductNotFoundException;
import com.skooldio.bootcamp.week01.repo.ProductAvailableRepository;
import com.skooldio.bootcamp.week01.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAvailableRepository productAvailableRepository;

    public List<Product> findProductByTitle(String title){
        Optional<List<Product>> result = productRepository.findByTitle(title);
        if(result.isPresent() && result.get().size() > 0){
            return result.get();
        }
        throw new ProductNotFoundException("Product '" + title + "' not found");
    }

    public Product findProductById(int id){
        Optional<Product> result =  productRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ProductNotFoundException("Product id not found");
    }

    public List<ProductAvailable> getProductAvailables(Product product){
        return productAvailableRepository.findByProduct(product);
    }
}

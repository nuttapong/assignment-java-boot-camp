package com.skooldio.bootcamp.week01.repo;

import com.skooldio.bootcamp.week01.entity.Product;
import com.skooldio.bootcamp.week01.entity.ProductAvailable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAvailableRepository extends JpaRepository<ProductAvailable, Integer> {
    List<ProductAvailable> findByProduct(Product product);
}

package com.skooldio.bootcamp.week01.repo;

import com.skooldio.bootcamp.week01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<List<Product>> findByTitle(String title);
    Optional<Product> findById(int id);
}

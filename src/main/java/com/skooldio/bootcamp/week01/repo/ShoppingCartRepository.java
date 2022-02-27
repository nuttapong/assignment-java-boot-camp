package com.skooldio.bootcamp.week01.repo;

import com.skooldio.bootcamp.week01.entity.ShoppingCart;
import com.skooldio.bootcamp.week01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    List<ShoppingCart> getShoppingCartByUser(User user);
}

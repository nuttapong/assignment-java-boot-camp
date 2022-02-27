package com.skooldio.bootcamp.week01;

import com.skooldio.bootcamp.week01.entity.ShoppingCart;
import com.skooldio.bootcamp.week01.entity.User;
import com.skooldio.bootcamp.week01.repo.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart addProductToShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartRepository.save(shoppingCart);
    }

    public List<ShoppingCart> getShoppingCartByUser(User user){
        return shoppingCartRepository.getShoppingCartByUser(user);
    }
}

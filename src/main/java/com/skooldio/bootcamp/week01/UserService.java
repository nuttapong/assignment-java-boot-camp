package com.skooldio.bootcamp.week01;

import com.skooldio.bootcamp.week01.entity.ShippingAddress;
import com.skooldio.bootcamp.week01.entity.User;
import com.skooldio.bootcamp.week01.repo.ShippingAddressRepository;
import com.skooldio.bootcamp.week01.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    private UserRepository userRepository;

    public User getUserInfoByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<ShippingAddress> getShippingAddress(String username){
        User user = getUserInfoByUsername(username);
        return shippingAddressRepository.findByUser(user);
    }
}

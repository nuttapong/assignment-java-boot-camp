package com.skooldio.bootcamp.week01.repo;

import com.skooldio.bootcamp.week01.entity.ShippingAddress;
import com.skooldio.bootcamp.week01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {
    List<ShippingAddress> findByUser(User user);
}

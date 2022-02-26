package com.skooldio.bootcamp.week01.repo;

import com.skooldio.bootcamp.week01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}

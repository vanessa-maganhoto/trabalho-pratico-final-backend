package com.dh.petshopservice.repository;

import com.dh.petshopservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

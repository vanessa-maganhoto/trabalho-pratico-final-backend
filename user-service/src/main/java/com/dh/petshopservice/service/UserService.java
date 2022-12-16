package com.dh.petshopservice.service;

import com.dh.petshopservice.configuration.security.DTO.UserDTO;
import com.dh.petshopservice.domain.repository.BillsFeignClient;
import com.dh.petshopservice.models.User;
import com.dh.petshopservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {

    private final BillsFeignClient cliente;

    public UserRepository repository;

    public UserService(BillsFeignClient cliente) {
        this.cliente = cliente;
    }

    public UserDTO findById(Integer id){
        Optional<User> userObj = repository.findById(id);
        User user = userObj.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new UserDTO(user);
    }
}

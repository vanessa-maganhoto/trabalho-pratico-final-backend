package com.dh.petshopservice.controller;

import com.dh.petshopservice.configuration.security.DTO.UserDTO;
import com.dh.petshopservice.domain.repository.BillsFeignClient;
import com.dh.petshopservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.AttributeNotFoundException;

@RestController
@RequestMapping("users")
public class UserController {


    private final BillsFeignClient cliente;
    private UserService service;

    public UserController(BillsFeignClient cliente) {
        this.cliente = cliente;
    }

    @GetMapping
    public ResponseEntity<String> getPet() {
        return ResponseEntity.ok("Gato " + cliente.get().getBody());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('providers')")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id)  {

        UserDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}

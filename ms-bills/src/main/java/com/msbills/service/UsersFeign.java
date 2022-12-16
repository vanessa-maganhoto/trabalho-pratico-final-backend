package com.msbills.service;

import com.msbills.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(name="users-claims-service")
public interface UsersFeign {

    @GetMapping("/{id}")
    ResponseEntity<List<UserDTO>> findById(@PathVariable("id") Integer id);
}

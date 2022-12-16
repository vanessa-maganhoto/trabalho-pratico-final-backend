package com.dh.petshopservice.domain.repository;

import com.dh.petshopservice.configuration.security.openfeign.KeycloakInterceptorConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "users-claims-service", url = "http://localhost:8090", configuration = KeycloakInterceptorConfiguration.class)
public interface BillsFeignClient {

    @GetMapping
    ResponseEntity<String> get();
}

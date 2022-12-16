package com.msbills.controller;

import com.msbills.dto.BillsDTO;
import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.AttributeNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @PostMapping
    @PreAuthorize("hasRole('providers')")
    public ResponseEntity<BillsDTO> insert(@RequestBody BillsDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getIdBill()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('providers')")
    public ResponseEntity<BillsDTO> findById(@PathVariable("id") Integer id) throws AttributeNotFoundException {

        BillsDTO dto = service.buscaPorId(id);
        return ResponseEntity.ok().body(dto);
    }



}
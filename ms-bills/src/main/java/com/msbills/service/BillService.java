package com.msbills.service;

import com.msbills.dto.BillsDTO;
import com.msbills.dto.UserDTO;
import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;
    private UsersFeign userFeign;

    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public BillsDTO insert(BillsDTO billsDTO){
        Bill bill = repository.save(billsDTO.toEntity());
        return new BillsDTO(bill);
    }

    public BillsDTO buscaPorId(Integer id) throws AttributeNotFoundException {

        return repository.findById(id)
                .map(p -> new BillsDTO(p))
                .orElseThrow(() -> new AttributeNotFoundException("Fatura não encontrada" + id));
    }

}

package com.msbills.dto;

import com.msbills.models.Bill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillsDTO {

    private String idBill;

    private String customerBill;

    private String productBill;

    private Double totalPrice;
    public BillsDTO(){}

    public BillsDTO(String idBill, String customerBill, String productBill, Double totalPrice) {
        this.idBill = idBill;
        this.customerBill = customerBill;
        this.productBill = productBill;
        this.totalPrice = totalPrice;
    }

    public Bill toEntity(){
        return new Bill(this.idBill, this.customerBill, this.productBill, this.totalPrice);
    }
    public BillsDTO(Bill bill){
        this.idBill = bill.getIdBill();
        this.customerBill = bill.getCustomerBill();
        this.productBill = bill.getProductBill();
        this.totalPrice = bill.getTotalPrice();
    }
}

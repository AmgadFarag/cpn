package com.amgadFarag.cpn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.amgadFarag.cpn.dtos.CustomerDTO;
import com.amgadFarag.cpn.dtos.FilterDTO;
import com.amgadFarag.cpn.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        try {
            return ResponseEntity.ok().body(customerService.getAllCustomers());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/getByFilter")
    public ResponseEntity<List<CustomerDTO>> getByFilter(@RequestBody FilterDTO filterDTO) {
        try {
            return ResponseEntity.ok().body(customerService.getCustomerByFilter(filterDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}

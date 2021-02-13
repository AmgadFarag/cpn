package com.amgadFarag.cpn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amgadFarag.cpn.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

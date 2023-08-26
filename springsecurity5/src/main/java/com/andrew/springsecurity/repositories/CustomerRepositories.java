package com.andrew.springsecurity.repositories;

import com.andrew.springsecurity.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositories extends CrudRepository<Customer, Integer> {
    List<Customer> findByEmail(String email);
}

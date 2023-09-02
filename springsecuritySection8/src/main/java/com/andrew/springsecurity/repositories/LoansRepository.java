package com.andrew.springsecurity.repositories;

import com.andrew.springsecurity.model.Loans;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoansRepository extends CrudRepository<Loans, Long> {

    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}

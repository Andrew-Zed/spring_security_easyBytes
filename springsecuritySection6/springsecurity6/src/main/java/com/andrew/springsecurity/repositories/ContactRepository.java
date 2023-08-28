package com.andrew.springsecurity.repositories;

import com.andrew.springsecurity.model.Cards;
import com.andrew.springsecurity.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {



}

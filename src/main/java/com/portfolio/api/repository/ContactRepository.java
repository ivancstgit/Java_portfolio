package com.portfolio.api.repository;

import com.portfolio.api.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
    
}

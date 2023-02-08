package com.portfolio.security.Aplication.Repository;

import com.portfolio.security.Aplication.Model.Contact;
import com.portfolio.security.Aplication.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}

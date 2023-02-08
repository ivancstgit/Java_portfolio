package com.portfolio.security.Aplication.Service.Interfaces;

import com.portfolio.security.Aplication.Model.Contact;
import com.portfolio.security.Aplication.Model.Persona;

import java.util.List;

public interface IContactService {

    public List<Contact> getContacts();
    public void saveContact(Contact pers);
    public void deleteContact(Long id);
    public Contact findContact(Long id);
}

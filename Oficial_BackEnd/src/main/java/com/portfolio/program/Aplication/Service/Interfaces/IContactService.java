package com.portfolio.program.Aplication.Service.Interfaces;

import com.portfolio.program.Aplication.Model.Contact;

import java.util.List;

public interface IContactService {

    public List<Contact> getContacts();
    public void saveContact(Contact pers);
    public void deleteContact(Long id);
    public Contact findContact(Long id);
}

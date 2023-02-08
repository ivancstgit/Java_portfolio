package com.portfolio.program.Aplication.Service;

import com.portfolio.program.Aplication.Model.Contact;
import com.portfolio.program.Aplication.Repository.ContactRepository;
import com.portfolio.program.Aplication.Service.Interfaces.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactService implements IContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void saveContact(Contact cont) {
        contactRepository.save(cont);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact findContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }
}

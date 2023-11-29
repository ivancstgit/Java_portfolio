package com.portfolio.api.service;

import com.portfolio.api.dto.ContactDto;
import com.portfolio.api.entity.Contact;
import com.portfolio.api.repository.ContactRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ContactService implements IService<Contact, ContactDto> {

    @Autowired
    ContactRepository contactRepository;


    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact add(ContactDto entity) {
        Contact contact = new Contact();
        contact.setIcon(entity.getIcon());
        contact.setLink(entity.getLink());
        contact.setSocial_name(entity.getSocial_name());
        
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Integer id, ContactDto entity) throws NotFoundException {
        
        Contact contact = this.findById(id);

        contact.setIcon(entity.getIcon());
        contact.setLink(entity.getLink());
        contact.setSocial_name(entity.getSocial_name());
        
        return contactRepository.save(contact);
    }

    @Override
    public Contact delete(Integer id) throws NotFoundException {
        Contact contact = this.findById(id);
        contactRepository.deleteById(id);
        return contact;
    }

    @Override
    public Contact findById(Integer id) throws NotFoundException {
        Optional<Contact> contact = contactRepository.findById(id);
        if (!contact.isPresent()) {
            throw new NotFoundException();
        }
        return contact.get();
    }

}

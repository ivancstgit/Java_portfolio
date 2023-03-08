/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.api.controller;

import com.portfolio.api.dto.Mensaje;
import com.portfolio.api.dto.ContactDto;
import com.portfolio.api.entity.Contact;
import com.portfolio.api.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "https://fir-portfolio-220a9.web.app")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/lista")
    public ResponseEntity<List<Contact>> list(){
        List<Contact> list = contactService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Contact> getById(@PathVariable("id") int id){
        if(!contactService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Contact contact = contactService.getOne(id).get();
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ContactDto contactDto){

        Contact contact = contactService.getOne(id).get();
        contact.setIcon(contactDto.getIcon());
        contact.setSocial_name(contactDto.getSocial_name());
        contact.setLink(contactDto.getLink());
        contactService.save(contact);
        return new ResponseEntity(new Mensaje("Contacto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!contactService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        contactService.delete(id);
        return new ResponseEntity(new Mensaje("Contacto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ContactDto contactDto){
        Contact contact = new Contact(contactDto.getIcon(),contactDto.getSocial_name(),contactDto.getLink());
        contactService.save(contact);
        return new ResponseEntity(new Mensaje("Contacto creado"), HttpStatus.OK);
    }


}

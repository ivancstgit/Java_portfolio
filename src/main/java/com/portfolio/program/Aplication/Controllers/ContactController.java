package com.portfolio.program.Aplication.Controllers;

import com.portfolio.program.Aplication.Model.Contact;
import com.portfolio.program.Aplication.Service.Interfaces.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private IContactService servContact;

    @GetMapping("/get")
    @CrossOrigin
    public List<Contact> getContacts() {
        return servContact.getContacts();
    }

    @GetMapping("/get/{id}")
    @CrossOrigin
    public Contact getContacts(@RequestParam Long id) {
        return servContact.findContact(id);
    }

    @PostMapping("/save")
    @CrossOrigin
    public ResponseEntity<String> newContact(@RequestBody Contact pers) {
        servContact.saveContact(pers);
        return ResponseEntity.ok("Registrado correctamente");
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        servContact.deleteContact(id);
        return ResponseEntity.ok("Eliminado Correctamente");
    }

    @PutMapping("/edit/{id}")
    @CrossOrigin
    public Contact changeContact(@PathVariable Long id,
                                 @RequestParam String icon,
                                 @RequestParam String social_name,
                                 @RequestParam String link,
                                 @RequestParam Long id_persona){
        Contact pers = servContact.findContact(id);
        pers.setIcon(icon);
        pers.setSocial_name(social_name);
        pers.setLink(link);
        pers.setId_persona(id_persona);
        servContact.saveContact(pers);
        return pers;
    }
}

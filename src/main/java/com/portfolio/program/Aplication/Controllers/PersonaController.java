package com.portfolio.program.Aplication.Controllers;

import com.portfolio.program.Aplication.Model.Persona;
import com.portfolio.program.Aplication.Service.Interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin("/**")
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    private IPersonaService servPersona;

    @GetMapping("/get")
    @CrossOrigin("/**")
    public ResponseEntity<List<Persona>> getPersonas() {
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(servPersona.getPersonas(),responseHeaders,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @CrossOrigin("/**")
    public Persona getPersonaById(@RequestParam Long id) {
        return servPersona.findPersona(id);
    }
    @PostMapping("/save")
    @CrossOrigin("/**")
    public ResponseEntity<String> newPersona(@RequestBody Persona pers) {
        servPersona.savePersona(pers);
        return ResponseEntity.ok("Registrado correctamente");
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin("/**")
    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
        servPersona.deletePersona(id);
        return ResponseEntity.ok("Eliminado Correctamente");
    }

    @PutMapping("/edit/{id}")
    @CrossOrigin("/**")
    public Persona changePersona(@PathVariable Long id,
                                 @RequestParam String name,
                                 @RequestParam String profile_img,
                                 @RequestParam String description,
                                 @RequestParam Long id_dom,
                                 @RequestParam Long id_user){
        Persona pers = servPersona.findPersona(id);
        pers.setName(name);
        pers.setProfile_img(profile_img);
        pers.setDescription(description);
        pers.setId_domicilio(id_dom);
        pers.setId_user(id_user);
        servPersona.savePersona(pers);
        return pers;
    }
}

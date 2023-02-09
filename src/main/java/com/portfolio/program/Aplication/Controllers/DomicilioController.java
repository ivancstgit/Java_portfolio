package com.portfolio.program.Aplication.Controllers;

import com.portfolio.program.Aplication.Model.Domicilio;
import com.portfolio.program.Aplication.Service.Interfaces.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("/**")
@RequestMapping("/api/domicilio")
public class DomicilioController {
    @Autowired
     IDomicilioService servDomicilio;

    @GetMapping("/get")
    @CrossOrigin("/**")
    public List<Domicilio> getDomicilios() {
        return servDomicilio.getDomicilios();
    }

    @GetMapping("/get/{id}")
    @CrossOrigin("/**")
    public Domicilio getDomicilioById(@RequestParam Long id) {
        return servDomicilio.findDomicilio(id);
    }
    @PostMapping("/save")
    @CrossOrigin("/**")
    public ResponseEntity<String> newDomicilio(@RequestBody Domicilio pers) {
        servDomicilio.saveDomicilio(pers);
        return ResponseEntity.ok("Registrado correctamente");
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin("/**")
    public ResponseEntity<String> deleteDomicilio(@PathVariable Long id) {
        servDomicilio.deleteDomicilio(id);
        return ResponseEntity.ok("Eliminado Correctamente");
    }

    @PutMapping("/edit/{id}")
    @CrossOrigin("/**")
    public Domicilio changeDomicilio(@PathVariable Long id,
                                     @RequestParam String localidad,
                                     @RequestParam String calle,
                                     @RequestParam Integer num,
                                     @RequestParam String body2){
        Domicilio pers = servDomicilio.findDomicilio(id);
        pers.setLocalidad(localidad);
        pers.setCalle(calle);
        pers.setNum(num);
        pers.setBody2(body2);
        servDomicilio.saveDomicilio(pers);
        return pers;
    }
}

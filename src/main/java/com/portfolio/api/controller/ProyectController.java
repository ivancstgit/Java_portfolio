package com.portfolio.api.controller;

import com.portfolio.api.dto.Response;
import com.portfolio.api.dto.ProyectDto;
import com.portfolio.api.entity.Proyect;
import com.portfolio.api.service.ProyectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
@RequestMapping("/proyect")
@CrossOrigin(origins = "https://fir-portfolio-220a9.web.app")
public class ProyectController {

    @Autowired
    ProyectService proyectService;

    @GetMapping
    public ResponseEntity<List<Proyect>> list(){
        List<Proyect> list = proyectService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
public ResponseEntity<Response<Proyect>> getById(@PathVariable("id") int id) {
    try {
        Proyect proyect = proyectService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Proyect>(proyect));
    } catch (NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("No existe"));
    }
    
}

    
    @PutMapping("/{id}")
    public ResponseEntity<Response<Proyect>> update(@PathVariable("id")Integer id, @RequestBody ProyectDto proyectDto){

        try {
            Proyect proyect = proyectService.update(id, proyectDto);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Proyect>("Proyect actualizado", proyect));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("No existe"));
        }

        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        try {
            Proyect proyect = proyectService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Proyect>("Proyect eliminado", proyect));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("No existe"));
        }
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProyectDto proyectDto){
        Proyect proyect = proyectService.add(proyectDto);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Proyect>("Proyect creado", proyect));
    }


}

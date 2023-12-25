package com.portfolio.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.api.dto.ProyectDto;
import com.portfolio.api.dto.Response;
import com.portfolio.api.entity.Proyect;
import com.portfolio.api.service.ProyectService;


@RestController
@RequestMapping("/proyect")
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
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Proyect not found"));
    }
    
}

    
    @PutMapping("/{id}")
    public ResponseEntity<Response<Proyect>> update(@PathVariable("id")Integer id,
            @ModelAttribute ProyectDto proyectDto){

        try {
            Proyect proyect = proyectService.update(id, proyectDto);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Proyect>("Proyect updated", proyect));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Proyect not found"));
        } catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>("Error with the img: " + e));
        }

        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        try {
            Proyect proyect = proyectService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Proyect>("Proyect deleted", proyect));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Proyect not found"));
        }
    }
    
    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute ProyectDto proyectDto){

        Proyect proyect;
        try {
            proyect = proyectService.add(proyectDto);
             return ResponseEntity.status(HttpStatus.OK).body(new Response<Proyect>("Proyect created", proyect));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<Proyect>("An error ocurred"));
        }
       
    }


}

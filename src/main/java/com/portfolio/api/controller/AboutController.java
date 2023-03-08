/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.api.controller;

import com.portfolio.api.dto.Mensaje;
import com.portfolio.api.dto.AboutDto;
import com.portfolio.api.entity.About;
import com.portfolio.api.service.AboutService;
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
@RequestMapping("/about")
@CrossOrigin(origins = "https://fir-portfolio-220a9.web.app")
public class AboutController {

    @Autowired
    AboutService aboutService;

    @GetMapping("/lista")
    public ResponseEntity<List<About>> list(){
        List<About> list = aboutService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id){
        if(!aboutService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        About about = aboutService.getOne(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody AboutDto aboutDto){

        About about = aboutService.getOne(id).get();
        about.setName(aboutDto.getName());
        about.setPorcent(aboutDto.getPorcent());
        about.setColor(aboutDto.getColor());
        aboutService.save(about);
        return new ResponseEntity(new Mensaje("About actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!aboutService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        aboutService.delete(id);
        return new ResponseEntity(new Mensaje("About eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AboutDto aboutDto){
        About about = new About(aboutDto.getName(),aboutDto.getPorcent(),aboutDto.getColor());
        aboutService.save(about);
        return new ResponseEntity(new Mensaje("About creado"), HttpStatus.OK);
    }


}

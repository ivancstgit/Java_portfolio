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

import com.portfolio.api.dto.ExperienceDto;
import com.portfolio.api.dto.Response;
import com.portfolio.api.entity.Experience;
import com.portfolio.api.service.ExperienceService;


@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @GetMapping
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = experienceService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
public ResponseEntity<Response<Experience>> getById(@PathVariable("id") int id) {
    try {
        Experience experience = experienceService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Experience>(experience));
    } catch (NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Experience not found"));
    }
    
}

    
    @PutMapping("/{id}")
    public ResponseEntity<Response<Experience>> update(@PathVariable("id")Integer id, @ModelAttribute ExperienceDto experienceDto){

        try {
            Experience experience = experienceService.update(id, experienceDto);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Experience>("Experience updated", experience));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Experience not found"));
        } catch (IOException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>("An error ocurred with the img: " + e.getMessage()));
            
        }

        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        try {
            Experience experience = experienceService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Experience>("Experience deleted", experience));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Experience not found"));
        }
    }
    
    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute ExperienceDto experienceDto){
        
        try{
            Experience experience = experienceService.add(experienceDto);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Experience>("Experience created", experience));
        } catch (IOException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>("An error ocurred with the img:" + e.getMessage()));
            
        }
    }


}

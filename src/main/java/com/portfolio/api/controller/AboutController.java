package com.portfolio.api.controller;

import com.portfolio.api.dto.Response;
import com.portfolio.api.dto.AboutDto;
import com.portfolio.api.entity.About;
import com.portfolio.api.service.AboutService;
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
@RequestMapping("/about")
@CrossOrigin(origins = "https://fir-portfolio-220a9.web.app")
public class AboutController {

    @Autowired
    AboutService aboutService;

    @GetMapping
    public ResponseEntity<List<About>> list(){
        List<About> list = aboutService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
public ResponseEntity<Response<About>> getById(@PathVariable("id") int id) {
    try {
        About about = aboutService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<About>(about));
    } catch (NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("No existe"));
    }
    
}

    
    @PutMapping("/{id}")
    public ResponseEntity<Response<About>> update(@PathVariable("id")Integer id, @RequestBody AboutDto aboutDto){

        try {
            About about = aboutService.update(id, aboutDto);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<About>("About actualizado", about));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("No existe"));
        }

        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        try {
            About about = aboutService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<About>("About eliminado", about));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("No existe"));
        }
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AboutDto aboutDto){
        About about = aboutService.add(aboutDto);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<About>("About creado", about));
    }


}

package com.portfolio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.api.dto.SkillsDto;
import com.portfolio.api.dto.Response;
import com.portfolio.api.entity.Skills;
import com.portfolio.api.service.SkillsService;


@RestController
@RequestMapping("/skills")
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    @GetMapping
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = skillsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
public ResponseEntity<Response<Skills>> getById(@PathVariable("id") int id) {
    try {
        Skills skills = skillsService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Skills>(skills));
    } catch (NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Skill not found"));
    }
    
}

    
    @PutMapping("/{id}")
    public ResponseEntity<Response<Skills>> update(@PathVariable("id")Integer id, @RequestBody SkillsDto skillsDto){

        try {
            Skills skills = skillsService.update(id, skillsDto);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Skills>("Skills updated", skills));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Skill not found"));
        }

        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        try {
            Skills skills = skillsService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Skills>("Skills deleted", skills));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Skill not found"));
        }
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody SkillsDto skillsDto){
        Skills skills = skillsService.add(skillsDto);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Skills>("Skills created", skills));
    }


}

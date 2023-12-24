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

import com.portfolio.api.dto.ProfileDto;
import com.portfolio.api.dto.Response;
import com.portfolio.api.entity.Profile;
import com.portfolio.api.service.ProfileService;


@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<Profile>> list(){
        List<Profile> list = profileService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
public ResponseEntity<Response<Profile>> getById(@PathVariable("id") int id) {
    try {
        Profile profile = profileService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Profile>(profile));
    } catch (NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Profile not found"));
    }
    
}

    
    @PutMapping("/{id}")
    public ResponseEntity<Response<Profile>> update(@PathVariable("id")Integer id, @RequestBody ProfileDto profileDto){

        try {
            Profile profile = profileService.update(id, profileDto);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Profile>("Profile updated", profile));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Profile not found"));
        }

        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        try {
            Profile profile = profileService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Profile>("Profile deleted", profile));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Profile not found"));
        }
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProfileDto profileDto){
        Profile profile = profileService.add(profileDto);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Profile>("Profile created", profile));
    }


}

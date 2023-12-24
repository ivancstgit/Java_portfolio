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

import com.portfolio.api.dto.MessageDto;
import com.portfolio.api.dto.Response;
import com.portfolio.api.entity.Message;
import com.portfolio.api.service.MessageService;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> list(){
        List<Message> list = messageService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
public ResponseEntity<Response<Message>> getById(@PathVariable("id") int id) {
    try {
        Message message = messageService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Message>(message));
    } catch (NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Message not found"));
    }
    
}

    
    @PutMapping("/{id}")
    public ResponseEntity<Response<Message>> update(@PathVariable("id")Integer id, @RequestBody MessageDto messageDto){

        try {
            Message message = messageService.update(id, messageDto);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Message>("Message updated", message));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Message not found"));
        }

        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        try {
            Message message = messageService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<Message>("Message deleted", message));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>("Message not found"));
        }
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody MessageDto messageDto){
        Message message = messageService.add(messageDto);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Message>("Message created", message));
    }


}

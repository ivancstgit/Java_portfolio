/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.api.controller;

import com.portfolio.api.dto.Mensaje;
import com.portfolio.api.entity.Portfolio;
import com.portfolio.api.service.PortfolioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/portfolio")
@CrossOrigin(origins = "https://fir-portfolio-220a9.web.app")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Portfolio>> list(){
        List<Portfolio> list = portfolioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Portfolio> getById(@PathVariable("id") int id){
        if(!portfolioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Portfolio producto = portfolioService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Portfolio productoDto){

        Portfolio producto = portfolioService.getOne(id).get();
        producto.setImage(productoDto.getImage());
        producto.setImage(productoDto.getImage());
        producto.setDescription(productoDto.getDescription());
        portfolioService.save(producto);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!portfolioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        portfolioService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


}

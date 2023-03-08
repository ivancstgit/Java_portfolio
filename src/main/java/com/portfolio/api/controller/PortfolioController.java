
package com.portfolio.api.controller;

import com.portfolio.api.dto.Mensaje;
import com.portfolio.api.dto.PortfolioDto;
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
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/get/{id}")
    public ResponseEntity<Portfolio> getById(@PathVariable("id") int id){
        if(!portfolioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Portfolio portfolio = portfolioService.getOne(id).get();
        return new ResponseEntity(portfolio, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{type}")
    public ResponseEntity<List<Portfolio>> getById(@PathVariable("type") String type){
        List<Portfolio> portfolio = portfolioService.getByType(type);
        return new ResponseEntity(portfolio, HttpStatus.OK);
    }
    

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Portfolio portfolioDto){

        Portfolio portfolio = portfolioService.getOne(id).get();
        
        portfolio.setDescription(portfolioDto.getDescription());
        portfolio.setImage(portfolioDto.getImage());
        portfolio.setTitle(portfolioDto.getTitle());
        portfolio.setState(portfolioDto.isState());
        portfolio.setType(portfolioDto.getType());
        
        portfolioService.save(portfolio);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!portfolioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        portfolioService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PortfolioDto portfolioDto){
        Portfolio portfolio = new Portfolio(portfolioDto.getDescription(),portfolioDto.getImage(),portfolioDto.getTitle(),portfolioDto.isState(),portfolioDto.getType());
        portfolioService.save(portfolio);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }


}

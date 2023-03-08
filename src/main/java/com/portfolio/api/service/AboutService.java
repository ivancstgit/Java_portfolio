/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.api.service;

import com.portfolio.api.entity.About;
import com.portfolio.api.repository.AboutRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AboutService {

    @Autowired
    AboutRepository aboutRepository;

    public List<About> list(){
        return aboutRepository.findAll();
    }

    public Optional<About> getOne(int id){
        return aboutRepository.findById(id);
    }


    public void  save(About about){
        aboutRepository.save(about);
    }

    public void delete(int id){
        aboutRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return aboutRepository.existsById(id);
    }

}

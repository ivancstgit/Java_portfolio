package com.portfolio.api.service;

import com.portfolio.api.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import com.portfolio.api.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {

    @Autowired
    PersonaRepository productoRepository;

    public List<Persona> list(){
        return productoRepository.findAll();
    }

    public Optional<Persona> getOne(int id){
        return productoRepository.findById(id);
    }


    public void  save(Persona persona){
        productoRepository.save(persona);
    }

    public void delete(int id){
        productoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return productoRepository.existsById(id);
    }

}

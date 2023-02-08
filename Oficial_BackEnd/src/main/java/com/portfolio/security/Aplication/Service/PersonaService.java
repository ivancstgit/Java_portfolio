package com.portfolio.security.Aplication.Service;

import com.portfolio.security.Aplication.Model.Persona;
import com.portfolio.security.Aplication.Repository.PersonaRepository;
import com.portfolio.security.Aplication.Service.Interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private PersonaRepository persoRepository;

    @Override
    public List<Persona> getPersonas() {
        return persoRepository.findAll();
    }

    @Override
    public void savePersona(Persona pers) {
        persoRepository.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return persoRepository.findById(id).orElse(null);
    }
}

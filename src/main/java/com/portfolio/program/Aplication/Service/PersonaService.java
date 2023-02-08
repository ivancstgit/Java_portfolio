package com.portfolio.program.Aplication.Service;

import com.portfolio.program.Aplication.Model.Persona;
import com.portfolio.program.Aplication.Repository.PersonaRepository;
import com.portfolio.program.Aplication.Service.Interfaces.IPersonaService;
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

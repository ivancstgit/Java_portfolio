package com.portfolio.security.Aplication.Service.Interfaces;

import com.portfolio.security.Aplication.Model.Persona;

import java.util.List;

public interface IPersonaService {

    public List<Persona> getPersonas();
    public void savePersona(Persona pers);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
}

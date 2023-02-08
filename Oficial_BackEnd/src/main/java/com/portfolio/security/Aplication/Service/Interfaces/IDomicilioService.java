package com.portfolio.security.Aplication.Service.Interfaces;

import com.portfolio.security.Aplication.Model.Domicilio;
import com.portfolio.security.Aplication.Model.Persona;

import java.util.List;

public interface IDomicilioService {

    public List<Domicilio> getDomicilios();
    public void saveDomicilio(Domicilio pers);
    public void deleteDomicilio(Long id);
    public Domicilio findDomicilio(Long id);
}

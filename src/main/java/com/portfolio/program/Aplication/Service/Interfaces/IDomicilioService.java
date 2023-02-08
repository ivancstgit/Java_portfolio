package com.portfolio.program.Aplication.Service.Interfaces;

import com.portfolio.program.Aplication.Model.Domicilio;

import java.util.List;

public interface IDomicilioService {

    public List<Domicilio> getDomicilios();
    public void saveDomicilio(Domicilio pers);
    public void deleteDomicilio(Long id);
    public Domicilio findDomicilio(Long id);
}

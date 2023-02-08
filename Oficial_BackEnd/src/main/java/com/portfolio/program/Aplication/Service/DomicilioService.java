package com.portfolio.program.Aplication.Service;

import com.portfolio.program.Aplication.Model.Domicilio;
import com.portfolio.program.Aplication.Repository.DomicilioRepository;
import com.portfolio.program.Aplication.Service.Interfaces.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    public List<Domicilio> getDomicilios() {
        return domicilioRepository.findAll();
    }

    @Override
    public void saveDomicilio(Domicilio dom) {
        domicilioRepository.save(dom);
    }

    @Override
    public void deleteDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public Domicilio findDomicilio(Long id) {
        return domicilioRepository.findById(id).orElse(null);
    }
}

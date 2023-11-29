package com.portfolio.api.service;

import com.portfolio.api.dto.ProyectDto;
import com.portfolio.api.entity.Proyect;
import com.portfolio.api.repository.ProyectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProyectService implements IService<Proyect, ProyectDto> {

    @Autowired
    ProyectRepository proyectRepository;


    @Override
    public List<Proyect> findAll() {
        return proyectRepository.findAll();
    }

    @Override
    public Proyect add(ProyectDto entity) {
        Proyect proyect = new Proyect();
        proyect.setDescription(entity.getDescription());
        proyect.setImage(entity.getImage());
        proyect.setState(entity.isState());
        proyect.setTitle(entity.getTitle());
        proyect.setType(entity.getType());

    
        
        return proyectRepository.save(proyect);
    }

    @Override
    public Proyect update(Integer id, ProyectDto entity) throws NotFoundException {
        
        Proyect proyect = this.findById(id);

        proyect.setDescription(entity.getDescription());
        proyect.setImage(entity.getImage());
        proyect.setState(entity.isState());
        proyect.setTitle(entity.getTitle());
        proyect.setType(entity.getType());
        
        return proyectRepository.save(proyect);
    }

    @Override
    public Proyect delete(Integer id) throws NotFoundException {
        Proyect proyect = this.findById(id);
        proyectRepository.deleteById(id);
        return proyect;
    }

    @Override
    public Proyect findById(Integer id) throws NotFoundException {
        Optional<Proyect> proyect = proyectRepository.findById(id);
        if (!proyect.isPresent()) {
            throw new NotFoundException();
        }
        return proyect.get();
    }

}

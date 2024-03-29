package com.portfolio.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.api.dto.ProyectDto;
import com.portfolio.api.entity.Proyect;
import com.portfolio.api.repository.ProyectRepository;

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
    public Proyect add(ProyectDto entity) throws IOException {
        Proyect proyect = new Proyect();
        proyect.setDescription(entity.getDescription());


        MultipartFile img = entity.getFile();
        String type = img.getContentType();
        if (type == null || !type.startsWith("image/")) {
            throw new IOException("Its not a image");
        }
        proyect.setImage(img.getBytes());

        proyect.setState(entity.isState());
        proyect.setTitle(entity.getTitle());
        proyect.setType(entity.getType());

        return proyectRepository.save(proyect);
    }

    @Override
    public Proyect update(Integer id, ProyectDto entity) throws NotFoundException, IOException {

        Proyect proyect = this.findById(id);

        proyect.setDescription(entity.getDescription());

       MultipartFile img = entity.getFile();
        String type = img.getContentType();
        if (type == null || !type.startsWith("image/")) {
            throw new IOException("Its not a image");
        }
        proyect.setImage(img.getBytes());

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

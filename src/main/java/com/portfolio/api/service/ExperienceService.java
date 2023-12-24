package com.portfolio.api.service;

import com.portfolio.api.dto.ExperienceDto;
import com.portfolio.api.entity.Experience;
import com.portfolio.api.repository.ExperienceRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
public class ExperienceService implements IService<Experience, ExperienceDto> {

    @Autowired
    ExperienceRepository experienceRepository;


    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience add(ExperienceDto entity) throws IOException {
        Experience experience = new Experience();
        
        experience.setDescription(entity.getDescription());

        MultipartFile img = entity.getFile();
        String type = img.getContentType();
        if (type == null || !type.startsWith("image/")) {
            throw new IOException("Its not a image");
        }
        experience.setImage(entity.getFile().getBytes());

        
        experience.setName(entity.getName());
        
        return experienceRepository.save(experience);
    }

    @Override
    public Experience update(Integer id, ExperienceDto entity) throws NotFoundException, IOException {
        
        Experience experience = this.findById(id);

        experience.setDescription(entity.getDescription());
        
        
        MultipartFile img = entity.getFile();
        String type = img.getContentType();
        if (type == null || !type.startsWith("image/")) {
            throw new IOException("Its not a image");
        }
        experience.setImage(entity.getFile().getBytes());

        experience.setName(entity.getName());
        
        return experienceRepository.save(experience);
    }

    @Override
    public Experience delete(Integer id) throws NotFoundException {
        Experience experience = this.findById(id);
        experienceRepository.deleteById(id);
        return experience;
    }

    @Override
    public Experience findById(Integer id) throws NotFoundException {
        Optional<Experience> experience = experienceRepository.findById(id);
        if (!experience.isPresent()) {
            throw new NotFoundException();
        }
        return experience.get();
    }

}

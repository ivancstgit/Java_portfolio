package com.portfolio.api.service;

import com.portfolio.api.dto.AboutDto;
import com.portfolio.api.entity.About;
import com.portfolio.api.repository.AboutRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AboutService implements IService<About, AboutDto> {

    @Autowired
    AboutRepository aboutRepository;


    @Override
    public List<About> findAll() {
        return aboutRepository.findAll();
    }

    @Override
    public About add(AboutDto entity) {
        About about = new About();
        about.setColor(entity.getColor());
        about.setPorcent(entity.getPorcent());
        about.setName(entity.getName());
        
        return aboutRepository.save(about);
    }

    @Override
    public About update(Integer id, AboutDto entity) throws NotFoundException {
        
        About about = this.findById(id);

        about.setColor(entity.getColor());
        about.setPorcent(entity.getPorcent());
        about.setName(entity.getName());
        
        return aboutRepository.save(about);
    }

    @Override
    public About delete(Integer id) throws NotFoundException {
        About about = this.findById(id);
        aboutRepository.deleteById(id);
        return about;
    }

    @Override
    public About findById(Integer id) throws NotFoundException {
        Optional<About> about = aboutRepository.findById(id);
        if (!about.isPresent()) {
            throw new NotFoundException();
        }
        return about.get();
    }

}

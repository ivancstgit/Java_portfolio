package com.portfolio.api.service;

import com.portfolio.api.dto.SkillsDto;
import com.portfolio.api.entity.Skills;
import com.portfolio.api.repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SkillsService implements IService<Skills, SkillsDto> {

    @Autowired
    SkillsRepository skillsRepository;


    @Override
    public List<Skills> findAll() {
        return skillsRepository.findAll();
    }

    @Override
    public Skills add(SkillsDto entity) {
        Skills skills = new Skills();
        skills.setPorcent(entity.getPorcent());
        skills.setName(entity.getName());
        
        return skillsRepository.save(skills);
    }

    @Override
    public Skills update(Integer id, SkillsDto entity) throws NotFoundException {
        
        Skills skills = this.findById(id);
        skills.setPorcent(entity.getPorcent());
        skills.setName(entity.getName());
        
        return skillsRepository.save(skills);
    }

    @Override
    public Skills delete(Integer id) throws NotFoundException {
        Skills skills = this.findById(id);
        skillsRepository.deleteById(id);
        return skills;
    }

    @Override
    public Skills findById(Integer id) throws NotFoundException {
        Optional<Skills> skills = skillsRepository.findById(id);
        if (!skills.isPresent()) {
            throw new NotFoundException();
        }
        return skills.get();
    }

}

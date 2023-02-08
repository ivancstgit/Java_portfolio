package com.portfolio.security.Aplication.Service;

import com.portfolio.security.Aplication.Model.Skills;
import com.portfolio.security.Aplication.Repository.SkillsRepository;
import com.portfolio.security.Aplication.Service.Interfaces.ISkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillsService implements ISkillsService {
    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public List<Skills> getSkills() {
        return skillsRepository.findAll();
    }

    @Override
    public void saveSkills(Skills skill) {
        skillsRepository.save(skill);
    }

    @Override
    public void deleteSkills(Long id) {
        skillsRepository.deleteById(id);
    }

    @Override
    public Skills findSkills(Long id) {
        return skillsRepository.findById(id).orElse(null);
    }
}

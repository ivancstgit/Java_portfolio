package com.portfolio.security.Aplication.Service.Interfaces;

import com.portfolio.security.Aplication.Model.Persona;
import com.portfolio.security.Aplication.Model.Skills;

import java.util.List;

public interface ISkillsService {

    public List<Skills> getSkills();
    public void saveSkills(Skills pers);
    public void deleteSkills(Long id);
    public Skills findSkills(Long id);

}

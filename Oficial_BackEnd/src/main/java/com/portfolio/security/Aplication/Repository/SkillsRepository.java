package com.portfolio.security.Aplication.Repository;

import com.portfolio.security.Aplication.Model.Persona;
import com.portfolio.security.Aplication.Model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {

}

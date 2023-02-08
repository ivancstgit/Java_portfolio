package com.portfolio.program.Aplication.Repository;

import com.portfolio.program.Aplication.Model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {

}

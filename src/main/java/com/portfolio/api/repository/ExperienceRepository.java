package com.portfolio.api.repository;

import com.portfolio.api.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
    
}

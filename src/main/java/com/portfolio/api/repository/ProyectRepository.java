
package com.portfolio.api.repository;

import com.portfolio.api.entity.Proyect;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectRepository extends JpaRepository<Proyect, Integer>{
    List<Proyect> findByType(String type);
}

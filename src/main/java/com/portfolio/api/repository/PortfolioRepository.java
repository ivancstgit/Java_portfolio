
package com.portfolio.api.repository;

import com.portfolio.api.entity.Portfolio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer>{
    List<Portfolio> findByType(String type);
}

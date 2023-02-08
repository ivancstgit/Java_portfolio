package com.portfolio.security.Aplication.Service;

import com.portfolio.security.Aplication.Model.Portfolio;
import com.portfolio.security.Aplication.Repository.PortfolioRepository;
import com.portfolio.security.Aplication.Service.Interfaces.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PortfolioService implements IPortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public List<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    @Override
    public void savePortfolio(Portfolio pers) {
        portfolioRepository.save(pers);
    }

    @Override
    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }

    @Override
    public Portfolio findPortfolio(Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }
}

package com.portfolio.security.Aplication.Service.Interfaces;

import com.portfolio.security.Aplication.Model.Persona;
import com.portfolio.security.Aplication.Model.Portfolio;

import java.util.List;

public interface IPortfolioService {

    public List<Portfolio> getPortfolios();
    public void savePortfolio(Portfolio pers);
    public void deletePortfolio(Long id);
    public Portfolio findPortfolio(Long id);
}

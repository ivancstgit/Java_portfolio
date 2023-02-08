package com.portfolio.program.Aplication.Service.Interfaces;

import com.portfolio.program.Aplication.Model.Portfolio;

import java.util.List;

public interface IPortfolioService {

    public List<Portfolio> getPortfolios();
    public void savePortfolio(Portfolio pers);
    public void deletePortfolio(Long id);
    public Portfolio findPortfolio(Long id);
}

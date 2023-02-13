/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.api.service;

import com.portfolio.api.entity.Portfolio;
import com.portfolio.api.repository.PortfolioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PortfolioService {

    @Autowired
    PortfolioRepository PortfolioRepository;

    public List<Portfolio> list(){
        return PortfolioRepository.findAll();
    }

    public Optional<Portfolio> getOne(int id){
        return PortfolioRepository.findById(id);
    }


    public void  save(Portfolio portfolio){
        PortfolioRepository.save(portfolio);
    }

    public void delete(int id){
        PortfolioRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return PortfolioRepository.existsById(id);
    }

}

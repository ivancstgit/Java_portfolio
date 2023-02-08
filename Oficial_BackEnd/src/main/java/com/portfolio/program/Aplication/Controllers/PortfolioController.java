package com.portfolio.program.Aplication.Controllers;

import com.portfolio.program.Aplication.Model.Portfolio;
import com.portfolio.program.Aplication.Service.Interfaces.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {
    @Autowired
    private IPortfolioService servPortfolio;

    @GetMapping("/get")
    public List<Portfolio> getPortfolios() {
        return servPortfolio.getPortfolios();
    }
    @GetMapping("/get/{id}")
    public Portfolio getPortfolioById(@RequestParam Long id) {
        return servPortfolio.findPortfolio(id);
    }
    @PostMapping("/save")
    public ResponseEntity<String> newPortfolio(@RequestBody Portfolio pers) {
        servPortfolio.savePortfolio(pers);
        return ResponseEntity.ok("Registrado correctamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePortfolio(@PathVariable Long id) {
        servPortfolio.deletePortfolio(id);
        return ResponseEntity.ok("Eliminado Correctamente");
    }

    @PutMapping("/edit/{id}")
    public Portfolio changePortfolio(@PathVariable Long id,
                                     @RequestParam String title,
                                     @RequestParam String image,
                                     @RequestParam String description,
                                     @RequestParam Long id_persona){
        Portfolio pers = servPortfolio.findPortfolio(id);
        pers.setTitle(title);
        pers.setImage(image);
        pers.setDescription(description);
        pers.setId_persona(id_persona);
        servPortfolio.savePortfolio(pers);
        return pers;
    }
}

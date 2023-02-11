package com.portfolio.program.Aplication.Controllers;

import com.portfolio.program.Aplication.Model.Portfolio;
import com.portfolio.program.Aplication.Service.Interfaces.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/portfolio")
public class PortfolioController {
    @Autowired
    private IPortfolioService servPortfolio;

    @GetMapping("/get")
    @CrossOrigin
    public List<Portfolio> getPortfolios() {
        return servPortfolio.getPortfolios();
    }
    @GetMapping("/get/{id}")
    @CrossOrigin
    public Portfolio getPortfolioById(@RequestParam Long id) {
        return servPortfolio.findPortfolio(id);
    }
    @PostMapping("/save")
    @CrossOrigin
    public ResponseEntity<String> newPortfolio(@RequestBody Portfolio pers) {
        servPortfolio.savePortfolio(pers);
        return ResponseEntity.ok("Registrado correctamente");
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<String> deletePortfolio(@PathVariable Long id) {
        servPortfolio.deletePortfolio(id);
        return ResponseEntity.ok("Eliminado Correctamente");
    }

    @PutMapping("/edit/{id}")
    @CrossOrigin
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

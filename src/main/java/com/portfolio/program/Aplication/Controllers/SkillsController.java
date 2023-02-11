package com.portfolio.program.Aplication.Controllers;

import com.portfolio.program.Aplication.Model.Skills;
import com.portfolio.program.Aplication.Service.Interfaces.ISkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/skills")
public class SkillsController {
    @Autowired
    private ISkillsService servSkills;

    @GetMapping("/get")
    @CrossOrigin
    public List<Skills> getSkillss() {
        return servSkills.getSkills();
    }
    @GetMapping("/get/{id}")
    @CrossOrigin
    public Skills getSkillsById(@RequestParam Long id) {
        return servSkills.findSkills(id);
    }
    @PostMapping("/save")
    @CrossOrigin
    public ResponseEntity<String> newSkills(@RequestBody Skills pers) {
        servSkills.saveSkills(pers);
        return ResponseEntity.ok("Registrado correctamente");
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteSkills(@PathVariable Long id) {
        servSkills.deleteSkills(id);
        return ResponseEntity.ok("Eliminado Correctamente");
    }

    @PutMapping("/edit/{id}")
    @CrossOrigin
    public Skills changeSkills(@PathVariable Long id,
                               @RequestParam String name,
                               @RequestParam String porcent,
                               @RequestParam String color,
                               @RequestParam Long id_persona){
        Skills pers = servSkills.findSkills(id);
        pers.setName(name);
        pers.setPorcent(porcent);
        pers.setColor(color);
        pers.setId_persona(id_persona);
        servSkills.saveSkills(pers);
        return pers;
    }
}

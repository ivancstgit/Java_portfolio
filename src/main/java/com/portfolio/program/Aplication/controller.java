package com.portfolio.program.Aplication;
import com.portfolio.program.Aplication.Model.Persona;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prueba")
@CrossOrigin
public class controller {

    public List<Persona> list;

    
    
    @GetMapping("/a")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
    
    @GetMapping("/b")
    public List<Persona> ola(){
        list.add(new Persona(1L, "tom", "", "", 1L,1L));
        list.add(new Persona(1L, "tom2", "", "", 1L,1L));
        list.add(new Persona(1L, "tom3", "", "", 1L,1L));
        return list;
    }

}


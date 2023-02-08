package com.portfolio.security.Aplication.Model;


import com.portfolio.security.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String profile_img;
    private String description;
    private Long id_domicilio;
    private Long id_user;

}

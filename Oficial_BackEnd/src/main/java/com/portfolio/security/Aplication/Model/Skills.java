package com.portfolio.security.Aplication.Model;

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
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String porcent;
    private String color;
    private Long id_persona;
}
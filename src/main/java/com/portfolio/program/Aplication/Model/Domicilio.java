package com.portfolio.program.Aplication.Model;

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
public class Domicilio {
    @Id
    @GeneratedValue
    private Long id;
    private String localidad;
    private String calle;
    private Integer num;
    private String body2;

}

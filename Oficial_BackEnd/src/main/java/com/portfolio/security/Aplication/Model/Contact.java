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
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    private String icon;
    private String social_name;
    private String link;
    private Long id_persona;

}
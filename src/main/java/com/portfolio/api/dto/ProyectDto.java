package com.portfolio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProyectDto {

    private String description;
    private String image;
    private String title;
    private boolean state;
    private String type;  

}

package com.portfolio.api.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProyectDto {

    private String description;
    private MultipartFile file;
    private String title;
    private boolean state;
    private String type;  

}

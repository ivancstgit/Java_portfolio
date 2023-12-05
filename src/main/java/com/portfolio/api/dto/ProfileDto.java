package com.portfolio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfileDto {
    
    
    private String name;
    
    private String profile_img;

    private String description;
}

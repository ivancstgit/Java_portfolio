package com.portfolio.api.dto;

import javax.validation.constraints.NotBlank;

public class PersonaDto {

    @NotBlank
    private String name;
    private String profile_img;
    private String description;

    public PersonaDto() {
    }

    public PersonaDto(@NotBlank String name, String profile_img, String description) {
        this.name = name;
        this.profile_img = profile_img;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

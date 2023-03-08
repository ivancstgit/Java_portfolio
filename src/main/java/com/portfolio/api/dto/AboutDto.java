package com.portfolio.api.dto;
import javax.validation.constraints.NotBlank;

public class AboutDto {
    
    private String name;
    private String porcent;
    private String color;

    public AboutDto() {
    }

    public AboutDto(String name, String porcent, String color) {
        this.name = name;
        this.porcent = porcent;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPorcent() {
        return porcent;
    }

    public void setPorcent(String porcent) {
        this.porcent = porcent;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    


}

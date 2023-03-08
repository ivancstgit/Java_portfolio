package com.portfolio.api.dto;
import javax.validation.constraints.NotBlank;

public class PortfolioDto {
     private String description;
    private String image;
    private String title;
    private boolean state;
    private String type;

    public PortfolioDto() {
    }

    public PortfolioDto(String description, String image, String title, boolean state, String type) {
        this.description = description;
        this.image = image;
        this.title = title;
        this.state = state;
        this.type = type;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    


}

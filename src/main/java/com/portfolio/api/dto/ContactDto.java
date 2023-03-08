package com.portfolio.api.dto;
import javax.validation.constraints.NotBlank;

public class ContactDto {
     private String icon;
    private String social_name;
    private String link;

    public ContactDto() {
    }

    public ContactDto(String icon, String social_name, String link) {
        this.icon = icon;
        this.social_name = social_name;
        this.link = link;
    }
    

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSocial_name() {
        return social_name;
    }

    public void setSocial_name(String social_name) {
        this.social_name = social_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}

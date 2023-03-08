package com.portfolio.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String icon;
    private String social_name;
    private String link;

    public Contact() {
    }

    public Contact(String icon, String social_name, String link) {
        this.icon = icon;
        this.social_name = social_name;
        this.link = link;
    }
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

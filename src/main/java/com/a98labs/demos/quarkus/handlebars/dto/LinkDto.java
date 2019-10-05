package com.a98labs.demos.quarkus.handlebars.dto;

public class LinkDto {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String text;
    public String url;
    
    public LinkDto(String text, String url) {
        this.text = text;
        this.url = url;
    }
    
}

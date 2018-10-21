package com.contacts.dto;

import com.contacts.entity.Contact;

public class ContactDto {

    private Long id;

    private String name;

    private String url;

    public Contact asEntity() {
        Contact entity = new Contact();
        entity.setName(getName());
        entity.setUrl(getUrl());
        return entity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

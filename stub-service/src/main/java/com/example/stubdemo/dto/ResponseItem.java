package com.example.stubdemo.dto;

import java.util.UUID;

public class ResponseItem {
    private String firstname;
    private String lastname;
    private UUID id;

    public ResponseItem(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = UUID.randomUUID();
    }

    // геттеры и сеттеры
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
}
package com.ay.sample.springboot.message.controller;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class MessageFrom {
    @NotNull
    private int id;

    @NotNull
    @Length(max = 10,min = 5)
    private String firstName;
    @NotNull
    @Length(max = 10,min = 5)
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package com.ay.sample.springboot.message.controller;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class MessageFrom {
    @NotNull
    private int id;

    @NotNull
    @Length(min = 5,max = 10,message = "exception.args.length.validate")
    private String firstName;
    @NotNull
    @Length(min = 5,max = 10,message = "exception.args.length.validate")
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

package com.xuanthongn.data.model.user;

import java.io.Serializable;

public class UserDto implements Serializable {
    private int userId;
    private String name;
    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserDto(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public UserDto(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

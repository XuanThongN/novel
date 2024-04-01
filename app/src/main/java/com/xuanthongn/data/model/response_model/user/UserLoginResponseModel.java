package com.xuanthongn.data.model.response_model.user;

import com.google.gson.annotations.SerializedName;

public class UserLoginResponseModel {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;


    public UserLoginResponseModel(String email, String password) {
        this.username = email;
        this.password = password;
    }

    public UserLoginResponseModel() {
    }


    public String getEmail() {
        return username;
    }

    public void setEmail(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginResponseModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.xuanthongn.data.model.response_model.user;

import com.google.gson.annotations.SerializedName;

public class UserRegisterRequestModel {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;
    @SerializedName("email")

    private String email;



    public UserRegisterRequestModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRegisterRequestModel(String username, String password, String first_name, String last_name, String email) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public UserRegisterRequestModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}

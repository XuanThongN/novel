package com.xuanthongn.data.model.response_model.user;

import com.google.gson.annotations.SerializedName;

public class UserLoginResponseModel {

    @SerializedName("token")
    private String token;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;
    @SerializedName("id")

    private String id;



    public UserLoginResponseModel() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserLoginResponseModel(String token, String username, String email, String name, String id) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.name = name;
        this.id = id;
    }
}

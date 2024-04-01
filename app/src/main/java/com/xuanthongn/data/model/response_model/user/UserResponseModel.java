package com.xuanthongn.data.model.response_model.user;

import com.google.gson.annotations.SerializedName;

public class UserResponseModel {

    @SerializedName("id")
    private int userId;

    @SerializedName("email")
    private String email;

//    private String password;

    @SerializedName("username")
    private String name;

    private String image;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserResponseModel(int userId, String email, String name, String image) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.image = image;
    }

    public UserResponseModel() {
    }

}

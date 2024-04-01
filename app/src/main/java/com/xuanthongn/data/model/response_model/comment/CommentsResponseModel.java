package com.xuanthongn.data.model.response_model.comment;

import com.google.gson.annotations.SerializedName;
import com.xuanthongn.data.model.response_model.user.UserResponseModel;

import java.time.LocalDateTime;


public class CommentsResponseModel {

    @SerializedName("id")
    private int id;
    @SerializedName("text")
    private String text;
    @SerializedName("user")
    private UserResponseModel author;
    @SerializedName("created_at")
    private LocalDateTime created_at;

    public CommentsResponseModel() {
    }

    public CommentsResponseModel(int id, String text, UserResponseModel author, LocalDateTime created_at) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserResponseModel getAuthor() {
        return author;
    }

    public void setAuthor(UserResponseModel author) {
        this.author = author;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}

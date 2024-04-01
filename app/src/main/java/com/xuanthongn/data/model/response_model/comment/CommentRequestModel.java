package com.xuanthongn.data.model.response_model.comment;

import com.google.gson.annotations.SerializedName;
import com.xuanthongn.data.model.response_model.user.UserResponseModel;

import java.time.LocalDateTime;


public class CommentRequestModel {
    @SerializedName("novel")
    private int novel_id;
    @SerializedName("text")
    private String content;
    @SerializedName("user")
    private int user_id;

    public CommentRequestModel(int novel_id, String content, int user_id) {
        this.novel_id = novel_id;
        this.content = content;
        this.user_id = user_id;
    }

    public int getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(int novel_id) {
        this.novel_id = novel_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

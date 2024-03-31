package com.xuanthongn.data.model.response_model.user;
import com.google.gson.annotations.SerializedName;

public class CommentResponseModel {
    private int Id;
    @SerializedName("text")
    private int text;
    @SerializedName("user")
    private int user_id;
    @SerializedName("novel")
    private int novel_id;

}

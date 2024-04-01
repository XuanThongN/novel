package com.xuanthongn.data.model.response_model.user;

import com.google.gson.annotations.SerializedName;

public class ChapterResponseModel {
    @SerializedName("chapterId")
    private int chapterId;

    @SerializedName("name")
    private String name;

    @SerializedName("content")
    private String content;

    @SerializedName("novel_id")
    private int novelId;

}

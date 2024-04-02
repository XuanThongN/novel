package com.xuanthongn.data.model.response_model.user;

import com.google.gson.annotations.SerializedName;

public class ChapterResponseModel {
    @SerializedName("id")
    private int chapterId;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("novel")
    private int novelId;

    public ChapterResponseModel() {
    }

    public ChapterResponseModel(int chapterId, String title, String content, int novelId) {
        this.chapterId = chapterId;
        this.title = title;
        this.content = content;
        this.novelId = novelId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }
}

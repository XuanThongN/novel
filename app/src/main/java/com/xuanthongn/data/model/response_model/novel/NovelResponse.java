package com.xuanthongn.data.model.response_model.novel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xuanthongn.data.model.response_model.user.ChapterResponseModel;

import java.util.List;

public class NovelResponse {
    @SerializedName("id")
    private int novelId;
    @SerializedName("title")
    private String title;
    @SerializedName("author")
    private String author;
    @SerializedName("image_path")
    private String image_path;
    @SerializedName("category")
    private int category_id;
    @SerializedName("chapters")
    private List<ChapterResponseModel> chapters;

    @SerializedName("comments")
    private List<String> comments;
    @SerializedName("image_url")
    private String image_url;

    public NovelResponse() {
    }

    public NovelResponse(int novelId, String title, String author, String image_path, int category_id, List<ChapterResponseModel> chapters, String image_url) {
        this.novelId = novelId;
        this.title = title;
        this.author = author;
        this.image_path = image_path;
        this.category_id = category_id;
        this.chapters = chapters;
        this.comments = comments;
        this.image_url = image_url;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public List<ChapterResponseModel> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterResponseModel> chapters) {
        this.chapters = chapters;
    }


    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}

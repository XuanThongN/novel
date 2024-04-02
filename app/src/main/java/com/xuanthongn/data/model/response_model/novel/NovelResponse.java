package com.xuanthongn.data.model.response_model.novel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xuanthongn.data.model.response_model.user.CategoryResponseModel;
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
    private CategoryResponseModel category;
    @SerializedName("chapters_count")
    private int chapters_count;

    @SerializedName("comments")
    private List<String> comments;

    @SerializedName("description")
    private String description;
    @SerializedName("image_url")
    private String image_url;

    public NovelResponse() {
    }

    public NovelResponse(int novelId, String title, String author, String image_path, CategoryResponseModel category, int chapters_count, String image_url, String description) {
        this.novelId = novelId;
        this.title = title;
        this.author = author;
        this.image_path = image_path;
        this.category = category;
        this.chapters_count = chapters_count;
        this.image_url = image_url;
        this.description = description;
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

    public CategoryResponseModel getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseModel category) {
        this.category = category;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public int getChapters_count() {
        return chapters_count;
    }

    public void setChapters_count(int chapters_count) {
        this.chapters_count = chapters_count;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

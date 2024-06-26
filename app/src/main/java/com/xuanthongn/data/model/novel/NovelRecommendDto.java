package com.xuanthongn.data.model.novel;

import java.io.Serializable;

public class NovelRecommendDto implements Serializable {
    private int id;
    private String name;
    private String author;
    private String description;
    private int chapters_count;
    private String imageUrl;
    private String categoryName;
    private int categoryId;

    public NovelRecommendDto(int id, String name, String author, String description, int chapters_count, String imageUrl, String categoryName, int categoryId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.chapters_count = chapters_count;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public NovelRecommendDto(int id, String name, String author, String description, String imageUrl, String categoryName) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
    }

    public NovelRecommendDto(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public NovelRecommendDto(String name, String imageUrl, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public NovelRecommendDto(String name, String imageUrl,  String description,String categoryName,int chapters_count) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.categoryName = categoryName;
        this.chapters_count = chapters_count;
    }

    public NovelRecommendDto(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public NovelRecommendDto(int id, String imageUrl, String name) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public NovelRecommendDto(int id, String imageUrl, String name, String categoryName, int categoryId) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public NovelRecommendDto(int id, String name, String description, String imageUrl, String categoryName, int categoryId, int chapters_count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.chapters_count = chapters_count;
    }

    public NovelRecommendDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getChapters_count() {
        return chapters_count;
    }

    public void setChapters_count(int chapters_count) {
        this.chapters_count = chapters_count;
    }
}

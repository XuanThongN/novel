package com.xuanthongn.data.dto;

public class NovelDto {
    public int novelId;
    public String name;
    public String author;
    public String description;
    public String imageUrl;
    public String categoryName;

    public NovelDto() {
    }

    public NovelDto(String name, String imageUrl, String categoryName) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
    }

    public NovelDto(String name, String author, String description, String imageUrl, String categoryName) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
    }

    public NovelDto(int novelId, String name,  String imageUrl, String categoryName) {
        this.novelId = novelId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
    }

    public int getNovelId() {
        return novelId;
    }
    public void setNovelId(int novelId) {
        this.novelId = novelId;
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
    public String getCategory_id() {
        return categoryName;
    }
    public void setCategory_id(String categoryName) {
        this.categoryName = categoryName;
    }
}

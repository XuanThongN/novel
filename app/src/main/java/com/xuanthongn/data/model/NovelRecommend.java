package com.xuanthongn.data.model;

public class NovelRecommend {
    private int id;
    private String name;
    private String author;
    private String description;
    private String imageUrl;
    private String categoryName;


    public NovelRecommend(int id, String name, String author, String description, String imageUrl, String categoryName) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
    }

    public NovelRecommend(int id,  String imageUrl,String name) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public NovelRecommend() {
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
}

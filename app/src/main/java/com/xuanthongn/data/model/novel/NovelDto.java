package com.xuanthongn.data.model.novel;

import java.io.Serializable;

public class NovelDto implements Serializable {
    private int id;
    private String name;
    private String imageUrl;
    private String author;
    private String description;
    private String categoryName;
    private int category_id;

    public NovelDto(int id, String name, String imageUrl, String categoryName) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
    }

    public NovelDto(int id, String name, String imageUrl, String author, String description, String categoryName, int category_id) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.author = author;
        this.description = description;
        this.categoryName = categoryName;
        this.category_id = category_id;
    }

    public NovelDto() {
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

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
    public String getCategoryName() {return categoryName;}
    public void setCategoryName(String categoryName) {this.categoryName = categoryName;}

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}

package com.xuanthongn.data.model.novel;

public class NovelCreateDto {
    public int novelId;
    public String name;
    public String author;
    public String description;
    public String imageUrl;
    private int categoryId;


    public NovelCreateDto() {
    }

    public NovelCreateDto(String name, String imageUrl, int categoryId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public NovelCreateDto(String name, String author, String description, String imageUrl, int categoryId) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public NovelCreateDto(int novelId, String name, String imageUrl, int categoryId) {
        this.novelId = novelId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
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
    public int getCategory_id() {
        return categoryId;
    }
    public void setCategory_id(int categoryId) {
        this.categoryId = categoryId;
    }
}

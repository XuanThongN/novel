package com.xuanthongn.data.model.novel;

public class NovelDto {
    private int id;
    private String name;
    private String imageUrl;
    private String categoryName;

    public NovelDto() {
    }

    public NovelDto(int id, String name, String imageUrl, String categoryName) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
    public String getCategoryName() {return categoryName;}
    public void setCategoryName(String categoryName) {this.categoryName = categoryName;}
}

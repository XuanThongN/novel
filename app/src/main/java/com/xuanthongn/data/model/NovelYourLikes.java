package com.xuanthongn.data.model;

import java.util.List;

public class NovelYourLikes {
    private int id;
    private String imageUrl;
    private String name;
    private String content;

    public NovelYourLikes(int id, String imageUrl, String name, String content) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.content = content;
    }

    public NovelYourLikes() {
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
}

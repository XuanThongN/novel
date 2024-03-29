package com.xuanthongn.data.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Novel {
    @PrimaryKey(autoGenerate = true)
    public int novelId;
    public String name;
    public String author;
    public String description;
    public String imageUrl;

    //Foreign key many-1
    public int category_id;

    public Novel() {
    }

    public Novel(String name, String imageUrl, int category_id) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.category_id = category_id;
    }

    public Novel(String name, String description, String imageUrl, int category_id) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category_id = category_id;
    }

    public Novel(int novelId, String name, String author, String description, String imageUrl, int category_id) {

        this.novelId = novelId;
        this.name = name;
        this.author = author;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category_id = category_id;
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
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}

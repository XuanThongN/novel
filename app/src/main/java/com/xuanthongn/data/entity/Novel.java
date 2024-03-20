package com.xuanthongn.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Novel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String author;
    private String description;
    private String imageUrl;

}

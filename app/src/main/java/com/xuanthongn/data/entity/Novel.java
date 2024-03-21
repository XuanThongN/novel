package com.xuanthongn.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Novel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String author;
    public String description;
    public String imageUrl;

}

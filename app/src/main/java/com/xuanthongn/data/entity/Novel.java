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

}

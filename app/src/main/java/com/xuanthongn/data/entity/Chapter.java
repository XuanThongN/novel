package com.xuanthongn.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Chapter {
    @PrimaryKey(autoGenerate = true)
    public int chapterId;
    public String name;
    public String content;

    //Foreign key many-1
    public int novel_id;

}

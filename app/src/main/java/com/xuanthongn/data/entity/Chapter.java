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

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(int novel_id) {
        this.novel_id = novel_id;
    }

    public Chapter(int chapterId, String name, String content, int novel_id) {
        this.chapterId = chapterId;
        this.name = name;
        this.content = content;
        this.novel_id = novel_id;
    }

    public Chapter() {
    }
}

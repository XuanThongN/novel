package com.xuanthongn.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Novel.class,
        parentColumns = "novelId",
        childColumns = "novel_id",
        onDelete = ForeignKey.CASCADE))
public class Chapter {
    @PrimaryKey(autoGenerate = true)
    public int chapterId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "novel_id")
    public int novel_id;

    public Chapter() {

    }

    public Chapter(int chapterId, String name, String content, int novel_id) {
        this.chapterId = chapterId;
        this.name = name;
        this.content = content;
        this.novel_id = novel_id;
    }

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
}

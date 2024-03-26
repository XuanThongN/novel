package com.xuanthongn.data.entity;

import androidx.room.Entity;

@Entity(primaryKeys = {"userId", "chapterId"})
public class UserReadingChapter {
    public int userId;
    public int chapterId;
    public long timestamp;
}

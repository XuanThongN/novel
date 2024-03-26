package com.xuanthongn.data.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.xuanthongn.data.entity.Chapter;
import com.xuanthongn.data.entity.User;
import com.xuanthongn.data.entity.UserReadingChapter;

import java.util.List;

public class UserWithChapters {
    @Embedded
    public User user;
    @Relation(
            parentColumn = "userId",
            entityColumn = "chapterId",
            associateBy = @Junction(UserReadingChapter.class)
    )
    public List<Chapter> chapters;
}
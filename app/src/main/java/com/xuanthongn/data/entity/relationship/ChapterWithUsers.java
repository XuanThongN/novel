package com.xuanthongn.data.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.xuanthongn.data.entity.Chapter;
import com.xuanthongn.data.entity.User;
import com.xuanthongn.data.entity.UserReadingChapter;

import java.util.List;

public class ChapterWithUsers {
    @Embedded
    public Chapter chapter;
    @Relation(
            parentColumn = "chapterId",
            entityColumn = "userId",
            associateBy = @Junction(UserReadingChapter.class)
    )
    public List<User> users;
}
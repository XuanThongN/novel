package com.xuanthongn.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.xuanthongn.data.entity.UserReadingChapter;
import com.xuanthongn.data.entity.relationship.ChapterWithUsers;
import com.xuanthongn.data.entity.relationship.UserWithChapters;

import java.util.List;

@Dao
public interface UserReadingChapterDao {
    @Insert
    void insert(UserReadingChapter userReadingChapter);

    @Transaction
    @Query("SELECT * FROM Chapter")
    public List<ChapterWithUsers> getChapterWithUsers();

    @Transaction
    @Query("SELECT * FROM User")
    public List<UserWithChapters> getUserWithChapters();
}

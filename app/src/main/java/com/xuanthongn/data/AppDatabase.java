package com.xuanthongn.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.xuanthongn.data.dao.CategoryDao;
import com.xuanthongn.data.dao.ChapterDao;
import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.dao.UserDao;
import com.xuanthongn.data.dao.UserReadingChapterDao;
import com.xuanthongn.data.entity.*;

@Database(entities = {User.class, Category.class, Novel.class, Chapter.class, UserReadingChapter.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract CategoryDao categoryDao();


    public abstract NovelDao novelDao();

    public abstract ChapterDao chapterDao();

    public abstract UserReadingChapterDao userReadingChapterDao();
}
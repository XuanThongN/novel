package com.xuanthongn.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.entity.relationship.NovelWithChapters;

import java.util.List;

@Dao
public interface NovelDao {
    @Query("SELECT * FROM novel")
    List<Novel> getAll();

    @Query("SELECT * FROM novel WHERE novelId = :id LIMIT 1")
    Novel findById(int id);

    @Query("SELECT * FROM novel ORDER BY novelId DESC LIMIT 4")
    List<Novel> getNewestNovel();

    @Query("SELECT * FROM Novel")
    LiveData<List<NovelWithCategory>> getAllNovelsWithCategories();

    @Insert
    void insertAll(Novel novels);

    @Delete
    void delete(Novel novel);

    @Transaction
    @Query("SELECT * FROM novel WHERE novelId = :novelId")
    NovelWithCategory getNovelWithCategory(int novelId);

    @Transaction
    @Query("SELECT * FROM novel")
    List<NovelWithCategory> getNovelsWithCategory();

    @Transaction
    @Query("SELECT * FROM novel WHERE novelId = :novelId")
    NovelWithChapters getNovelWithChapters(int novelId);


}

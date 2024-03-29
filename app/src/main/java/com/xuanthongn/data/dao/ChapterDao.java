package com.xuanthongn.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.xuanthongn.data.entity.Chapter;
import com.xuanthongn.data.entity.relationship.ChapterWithNovel;
import com.xuanthongn.data.entity.relationship.NovelWithChapters;

import java.util.List;

@Dao
public interface ChapterDao {
    @Query("SELECT * FROM chapter")
    List<Chapter> getAll();

    @Query("SELECT * FROM chapter WHERE chapterId = :id LIMIT 1")
    Chapter findById(int id);

    @Insert
    void insertAll(Chapter... chapters);

    @Delete
    void delete(Chapter chapter);

    @Transaction
    @Query("SELECT * FROM chapter WHERE chapterId = :chapterId")
    ChapterWithNovel getChapterWithNovel(int chapterId);

    @Query("SELECT * FROM chapter WHERE novel_id = :id ORDER BY chapterId LIMIT 1")
    Chapter getChapterByNovelID(int id);

    @Transaction
    @Query("SELECT * FROM Chapter WHERE novel_id = :novelId")
    public List<ChapterWithNovel> getNovelWithChapters(int novelId);

    @Transaction
    @Query("SELECT * FROM Chapter WHERE novel_id = :novelId ORDER BY chapterId DESC LIMIT 4")
    public List<ChapterWithNovel> getNovelWithChaptersNew(int novelId);



}

package com.xuanthongn.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.User;
import com.xuanthongn.data.entity.relationship.NovelNameAndImageUrl;
import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.entity.relationship.NovelWithChapters;

import java.util.List;

@Dao
public interface NovelDao {
    @Query("SELECT * FROM novel")
    List<Novel> getAll();

    @Query("SELECT * FROM novel WHERE novelId = :id LIMIT 1")
    Novel findById(int id);

    @Query("SELECT name, imageUrl FROM novel WHERE name=:name LIMIT 1")
    NovelNameAndImageUrl getByNameAndImageUrl(String name);

    @Transaction
    @Query("SELECT * FROM Novel WHERE novelId = :id")
    public NovelWithCategory findNovelWithCategoryById(int id);

    @Query("SELECT * FROM novel ORDER BY novelId DESC LIMIT 4")
    List<Novel> getNewestNovel();

//    @Query("SELECT * FROM Novel WHERE novelId = :categoryId ORDER BY novelId DESC LIMIT 5")
//    List<Novel> findLatestNovelsByCategory(int categoryId);
    @Transaction
    @Query("SELECT * FROM novel WHERE category_id = :categoryId")
    List<NovelWithCategory> findLatestNovelsByCategory(int categoryId);

    @Query("SELECT * FROM Novel")
    LiveData<List<NovelWithCategory>> getAllNovelsWithCategories();

    @Insert
    void insertAll(Novel novels);

    @Delete
    void delete(Novel novel);
    @Transaction
    @Query("SELECT * FROM novel WHERE name LIKE '%' || :search  || '%' " + "OR description LIKE '%' || :search  || '%'")
    List<NovelWithCategory> searchNovelWithCategory(String search);

    @Transaction
    @Query("SELECT * FROM Novel")
    public List<NovelWithCategory> getNovelWithCategory();

    @Transaction
    @Query("SELECT * FROM novel")
    List<NovelWithCategory> getNovelsWithCategory();

    @Transaction
    @Query("SELECT * FROM novel WHERE novelId = :novelId")
    NovelWithChapters getNovelWithChapters(int novelId);


}

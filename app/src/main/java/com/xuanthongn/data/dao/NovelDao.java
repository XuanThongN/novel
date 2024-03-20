package com.xuanthongn.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.xuanthongn.data.entity.Novel;
import java.util.List;

@Dao
public interface NovelDao {
    @Query("SELECT * FROM novel")
    List<Novel> getAll();

    @Query("SELECT * FROM novel WHERE id = :id LIMIT 1")
    Novel findById(int id);

    @Insert
    void insertAll(Novel... novels);

    @Delete
    void delete(Novel novel);
}

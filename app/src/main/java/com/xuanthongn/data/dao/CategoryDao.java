package com.xuanthongn.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.xuanthongn.data.entity.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM categories")
    List<Category> getAll();

    @Query("SELECT * FROM categories WHERE id = :id LIMIT 1")
    Category findById(int id);

    @Insert
    void insertAll(Category... categories);

    @Delete
    void delete(Category category);
}

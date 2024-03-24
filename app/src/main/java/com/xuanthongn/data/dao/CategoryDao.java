package com.xuanthongn.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;


import com.xuanthongn.data.entity.Category;
import com.xuanthongn.data.entity.relationship.CategoryWithNovels;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM category")
    List<Category> getAll();

    @Query("SELECT * FROM category WHERE categoryId = :id LIMIT 1")
    Category findById(int id);

    @Insert
    void insertAll(Category... categories);

    @Delete
    void delete(Category category);

    @Transaction
    @Query("SELECT * FROM category WHERE categoryId = :id")
    CategoryWithNovels getCategoryWithNovels(int id);

}

package com.xuanthongn.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.xuanthongn.data.entity.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM products")
    List<Product> getAll();

    @Query("SELECT * FROM products")
    List<Product> getHotProducts();

    @Insert
    void insertAll(Product... products);

    @Delete
    void delete(Product product);
}

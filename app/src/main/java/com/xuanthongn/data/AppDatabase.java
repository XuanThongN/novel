package com.xuanthongn.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.xuanthongn.data.dao.CategoryDao;
import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.dao.ProductDao;
import com.xuanthongn.data.dao.UserDao;
import com.xuanthongn.data.entity.*;
import com.xuanthongn.data.entity.Product;

@Database(entities = {User.class, Category.class, Product.class, Novel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract CategoryDao categoryDao();

    public abstract ProductDao productDao();

    public abstract NovelDao novelDao();
}
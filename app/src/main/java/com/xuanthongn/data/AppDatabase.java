package com.xuanthongn.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.xuanthongn.data.dao.CategoryDao;
import com.xuanthongn.data.dao.ProductDao;
import com.xuanthongn.data.dao.UserDao;
import com.xuanthongn.data.model.Category;
import com.xuanthongn.data.model.Product;
import com.xuanthongn.data.model.User;

@Database(entities = {User.class, Category.class, Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract CategoryDao categoryDao();
    public abstract ProductDao productDao();
}
package com.xuanthongn.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.xuanthongn.data.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE EMAIL=:email LIMIT 1")
    User findByEmail(String email);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}

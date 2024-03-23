package com.xuanthongn.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.xuanthongn.data.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE userId=:id LIMIT 1")
    List<User> getById(int id);

    @Query("SELECT * FROM user WHERE EMAIL=:email LIMIT 1")
    User findByEmail(String email);

    @Insert
    void insertAll(User... users);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

}

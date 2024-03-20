package com.xuanthongn.data.repository;

import com.xuanthongn.data.dao.UserDao;
import com.xuanthongn.data.model.User;
import com.xuanthongn.util.Commons;

public class UserRepository {

    private final UserDao userDao;

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String username, String password) {
        // Hash password before comparison
        String passwordHash = Commons.hashPassword(password);
        User user = userDao.findByEmail(username);
        if (user != null && user.password.equals(passwordHash)) {
            return user;
        }
        return null;
    }

}


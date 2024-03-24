package com.xuanthongn.data.repository;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.UserDao;
import com.xuanthongn.data.entity.User;
import com.xuanthongn.data.model.UserDto;
import com.xuanthongn.util.Commons;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepository implements IUserRepository {
    private AppDatabase appDatabase;
    private final UserDao userDao;
    private final ModelMapper modelMapper;

    public UserRepository(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
        userDao = appDatabase.userDao();
        modelMapper = new ModelMapper();
    }

    @Override
    public UserDto findById(int id) {
        User user = userDao.getById(id).get(0);
        return modelMapper.map(user, UserDto.class);

    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userDao.getAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto insert(UserDto input) {
        userDao.insertAll(modelMapper.map(input, User.class));
        return input;
    }

    @Override
    public UserDto update(UserDto input) {
        userDao.update(modelMapper.map(input, User.class));
        return input;
    }

    @Override
    public void delete(UserDto user) {
        userDao.delete(modelMapper.map(user, User.class));
    }

    @Override
    public UserDto login(String username, String password) {
        User user = userDao.findByEmail(username);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        if (userDto != null && userDto.getPassword().equals(Commons.hashPassword(password))) {
            return userDto;
        }
        return null;
    }

}


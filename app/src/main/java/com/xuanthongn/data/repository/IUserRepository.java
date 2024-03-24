package com.xuanthongn.data.repository;

import com.xuanthongn.data.model.UserDto;

public interface IUserRepository extends IBaseRepository<UserDto> {
    UserDto login(String username, String password);
}

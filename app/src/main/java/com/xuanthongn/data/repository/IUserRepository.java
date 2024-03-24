package com.xuanthongn.data.repository;

import com.xuanthongn.data.model.UserDto;

public interface IUserRepository extends IBaseRepository<UserDto> {
    UserDto findByEmail(String email);
}

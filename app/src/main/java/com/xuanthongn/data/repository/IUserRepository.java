package com.xuanthongn.data.repository;

import com.xuanthongn.data.model.user.UserDto;

public interface IUserRepository extends IBaseRepository<UserDto> {
    UserDto findByEmail(String email);
}

package com.xuanthongn.data.api;


import android.database.Observable;

import com.xuanthongn.data.model.response_model.user.UserLoginResponseModel;
import com.xuanthongn.data.model.user.UserLoginDto;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUserService {
    @POST("/login")
    Observable<UserLoginResponseModel> login(@Body UserLoginDto body);
}

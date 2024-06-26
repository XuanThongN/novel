package com.xuanthongn.data.api.services;



import com.xuanthongn.data.model.response_model.user.UserLoginResponseModel;
import com.xuanthongn.data.model.response_model.user.UserRegisterRequestModel;
import com.xuanthongn.data.model.response_model.user.UserRegisterResponseModel;
import com.xuanthongn.data.model.user.UserLoginDto;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUserService {
    @POST("/api-token-auth")
    Observable<UserLoginResponseModel> login( @Body UserLoginDto body);

    @POST("/register")
    Observable<UserRegisterResponseModel> register(@Body UserRegisterRequestModel body);
}

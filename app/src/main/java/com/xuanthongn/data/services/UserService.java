package com.xuanthongn.data.services;

import com.xuanthongn.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class UserService implements IGenericService<User> {

    private static final String ENDPOINT = "/users";


    @Override
    @GET(ENDPOINT)
    public Call<List<User>> getList(String token) {
        return null;
    }

    @Override
    @POST(ENDPOINT)
    public Call<User> create(String token, User item) {
        return null;
    }

    @Override
    @POST(ENDPOINT)
    public Call<User> update(String token, User item) {
        return null;
    }

    @Override
    @POST(ENDPOINT)
    public Call<Void> delete(String token, User item) {
        return null;
    }
}

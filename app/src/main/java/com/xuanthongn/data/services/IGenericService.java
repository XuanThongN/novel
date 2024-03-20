package com.xuanthongn.data.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IGenericService<T> {

    @GET("/{endpoint}")
    Call<List<T>> getList(@Header("Authorization") String token);

    @POST("/{endpoint}")
    Call<T> create(@Header("Authorization") String token, @Body T item);

    @POST("/{endpoint}")
    Call<T> update(@Header("Authorization") String token, @Body T item);

    @POST("/{endpoint}")
    Call<Void> delete(@Header("Authorization") String token, @Body T item);
}

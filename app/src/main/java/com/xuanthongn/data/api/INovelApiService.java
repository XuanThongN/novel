package com.xuanthongn.data.api;

import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface INovelApiService {
    @GET("/novels")
    Observable<NovelsResponseModel> getList(@Header("Authorization") String token, @Query("page") int page);

    @POST("/novels")
    Call<Novel> create(@Header("Authorization") String token, @Body Novel item);

    @POST("/novels")
    Call<Novel> update(@Header("Authorization") String token, @Body Novel item);

    @POST("/novels")
    Call<Void> delete(@Header("Authorization") String token, @Body Novel item);
}

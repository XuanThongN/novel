package com.xuanthongn.data.api.services;

import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.response_model.novel.NovelResponse;
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

    @GET("/novels/get_relative_novels_by_category_id")
    Observable<List<NovelResponse>> getRelativeNovelsByCategoryId(@Header("Authorization") String token, @Query("novel_id") int novelId, @Query("category_id") int categoryId);

    @GET("/novels")
    Observable<NovelsResponseModel> search(@Header("Authorization") String token, @Query("search") String query);

    @POST("/novels")
    Call<Novel> create(@Header("Authorization") String token, @Body Novel item);

    @POST("/novels")
    Call<Novel> update(@Header("Authorization") String token, @Body Novel item);

    @POST("/novels")
    Call<Void> delete(@Header("Authorization") String token, @Body Novel item);
}

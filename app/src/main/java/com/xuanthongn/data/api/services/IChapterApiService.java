package com.xuanthongn.data.api.services;

import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;
import com.xuanthongn.data.model.response_model.user.ChapterResponseModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IChapterApiService {
    @GET("/chapters/get_chapters_by_novel_id")
    Observable<List<ChapterResponseModel>> getByNovel(@Header("Authorization") String token, @Query("novel_id") int novelId);

    @GET("/chapters/get_newest_chapters_by_novel_id")
    Observable<List<ChapterResponseModel>> getNewestByNovel(@Header("Authorization") String token, @Query("novel_id") int novelId);

}

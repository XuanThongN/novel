package com.xuanthongn.data.api;

import com.xuanthongn.data.model.response_model.comment.CommentRequestModel;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ICommentApiService {
    @GET("/comments/get_comments_by_novel_id")
    Observable<List<CommentsResponseModel>> getByNovelId(@Header("Authorization") String token, @Query("novel_id") int novel_id);

    @POST("/comments")
    Observable<CommentsResponseModel> create(@Header("Authorization") String token, @Body CommentRequestModel commentRequestModel);

}

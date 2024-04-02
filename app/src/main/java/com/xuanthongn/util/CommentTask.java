package com.xuanthongn.util;


import com.xuanthongn.data.api.services.ICommentApiService;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.response_model.comment.CommentRequestModel;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;


public class CommentTask {

    String token = "Token " + Constants.TOKEN;

    public void getCommentsByNovelId(final Callback<List<CommentsResponseModel>> callback, int novel_id) {
        RetrofitClient.getInstance().create(ICommentApiService.class)
                .getByNovelId(token, novel_id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<CommentsResponseModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CommentsResponseModel> commentResponseModels) {
                        callback.returnResult(commentResponseModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError("Bình luận chứa ngôn ngữ xúc phạm hoặc không hợp lệ");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void postComment(final Callback<CommentsResponseModel> callback, CommentRequestModel commentRequestModel) {
        RetrofitClient.getInstance().create(ICommentApiService.class)
                .create(token, commentRequestModel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CommentsResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommentsResponseModel commentResponseModels) {
                        callback.returnResult(commentResponseModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        String errorMessage = e.getMessage();
                        try {
                            if (e instanceof HttpException) {
                                HttpException httpException = (HttpException) e;
                                ResponseBody errorBody = httpException.response().errorBody();
                                errorMessage = errorBody.string();
                            } else {
                                // Handle other errors (network, etc.)
                                errorMessage = e.getMessage(); // Could provide a more user-friendly message here
                            }
                        } catch (IOException ex) {
                            errorMessage = ex.getMessage();
                        }
                        callback.returnError(errorMessage);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
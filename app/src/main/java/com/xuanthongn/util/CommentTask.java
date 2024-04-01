package com.xuanthongn.util;


import com.xuanthongn.data.api.ICommentApiService;
import com.xuanthongn.data.api.INovelApiService;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.response_model.comment.CommentRequestModel;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


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
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
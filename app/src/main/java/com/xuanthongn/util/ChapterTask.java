package com.xuanthongn.util;

import android.content.Context;
import android.widget.Toast;

import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.api.services.IChapterApiService;
import com.xuanthongn.data.api.services.INovelApiService;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;
import com.xuanthongn.data.model.response_model.user.ChapterResponseModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

public class ChapterTask {
    public void getByNovel(final Callback<List<ChapterResponseModel>> callback, int novelId) {
        RetrofitClient.getInstance().create(IChapterApiService.class)
                .getByNovel("Token " + Constants.TOKEN, novelId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<ChapterResponseModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ChapterResponseModel> chapterResponseModels) {
                        callback.returnResult(chapterResponseModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        String errorMessage = e.getMessage();
                        if (e instanceof HttpException) {
                            errorMessage = Commons.getHttpExceptionMessage(e);
                        }
                        callback.returnError(errorMessage);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //    Get các chương mới nhất của novel
    public void getNewestByNovel(final Callback<List<ChapterResponseModel>> callback, int novelId) {
        RetrofitClient.getInstance().create(IChapterApiService.class)
                .getNewestByNovel("Token " + Constants.TOKEN, novelId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<ChapterResponseModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ChapterResponseModel> chapterResponseModels) {
                        callback.returnResult(chapterResponseModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        String errorMessage = e.getMessage();
                        if (e instanceof HttpException) {
                            errorMessage = Commons.getHttpExceptionMessage(e);
                        }
                        callback.returnError(errorMessage);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

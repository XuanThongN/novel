package com.xuanthongn.util;


import com.xuanthongn.data.api.services.INovelApiService;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class NovelTask {

    String token = "Token " + Constants.TOKEN;

    public void getNovels(final Callback<NovelsResponseModel> callback) {
        RetrofitClient.getInstance().create(INovelApiService.class)
                .getList(token, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<NovelsResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NovelsResponseModel novelResponseModels) {
                        callback.returnResult(novelResponseModels);
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
package com.xuanthongn.util;


import com.xuanthongn.data.api.services.INovelApiService;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.api.services.IUserService;
import com.xuanthongn.data.model.response_model.novel.NovelResponse;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;
import com.xuanthongn.data.model.response_model.user.UserRegisterRequestModel;
import com.xuanthongn.data.model.response_model.user.UserRegisterResponseModel;


import java.util.List;

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

    public void getRelativeNovelsByCategoryId(final Callback<List<NovelResponse>> callback, final int novelId, final int categoryId) {
        RetrofitClient.getInstance().create(INovelApiService.class)
                .getRelativeNovelsByCategoryId(token,novelId,categoryId )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<NovelResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<NovelResponse> novelResponseModels) {
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




    public void getRegister(final Callback<UserRegisterResponseModel> callback,  UserRegisterRequestModel userRegisterRequestModel) {
        RetrofitClient.getInstance().create(IUserService.class)
                .register(userRegisterRequestModel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserRegisterResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserRegisterResponseModel userRegisterRequestModel) {
                        callback.returnResult(userRegisterRequestModel);
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
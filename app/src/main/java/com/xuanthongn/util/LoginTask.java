package com.xuanthongn.util;

import com.xuanthongn.data.api.ICommentApiService;
import com.xuanthongn.data.api.IUserService;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;
import com.xuanthongn.data.model.response_model.user.UserLoginResponseModel;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.data.model.user.UserLoginDto;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginTask {
    public void getLogin(final Callback<UserLoginResponseModel> callback, final String username, final String password) {
        UserLoginDto userLoginDto = new UserLoginDto(username, password);
        RetrofitClient.getInstance().create(IUserService.class)
                .login(userLoginDto)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserLoginResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserLoginResponseModel loginResponseModel) {
                        callback.returnResult(loginResponseModel);
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

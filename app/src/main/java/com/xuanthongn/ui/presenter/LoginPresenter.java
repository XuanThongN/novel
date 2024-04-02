package com.xuanthongn.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.dao.UserDao;
import com.xuanthongn.data.entity.User;
import com.xuanthongn.data.model.response_model.user.UserLoginResponseModel;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.data.model.user.UserLoginDto;
import com.xuanthongn.data.repository.UserRepository;
import com.xuanthongn.ui.constract.ILoginConstract;
import com.xuanthongn.util.Commons;
import com.xuanthongn.util.Constants;
import com.xuanthongn.util.LoginTask;

public class LoginPresenter implements ILoginConstract.IPresenter {
    private ILoginConstract.IView mView;
    private final AppDatabase db;
    private UserRepository userRepository;
    LoginTask loginTask;

    public LoginPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        userRepository = new UserRepository(db);
        loginTask = new LoginTask();
    }

    @Override
    public void setView(ILoginConstract.IView view) {
        mView = view;
    }

    @Override
    public void login(String name, String password) {
        loginTask.getLogin(new Callback<UserLoginResponseModel>() {
            @Override
            public void returnResult(UserLoginResponseModel result) {
                if (result != null) {
                    mView.loginSuccess(result);
                } else {
                    mView.loginFailed(Constants.LOGIN_STATUS.EMAIL_ERROR);
                }
            }

            @Override
            public void returnError(String errorMessage) {
                mView.loginFailed(Constants.LOGIN_STATUS.PASSWORD_ERROR);
            }
        }, name, password);
    }

}

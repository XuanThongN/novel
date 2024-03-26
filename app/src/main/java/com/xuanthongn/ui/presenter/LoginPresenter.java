package com.xuanthongn.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.data.repository.UserRepository;
import com.xuanthongn.ui.constract.ILoginConstract;
import com.xuanthongn.util.Commons;
import com.xuanthongn.util.Constants;

public class LoginPresenter implements ILoginConstract.IPresenter {
    private ILoginConstract.IView mView;
    private final AppDatabase db;
    private UserRepository userRepository;

    public LoginPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        userRepository = new UserRepository(db);
    }

    @Override
    public void setView(ILoginConstract.IView view) {
        mView = view;
    }

    @Override
    public void login(String email, String password) {
        UserDto user = userRepository.findByEmail(email);
        if (user == null) {
            mView.loginFailed(Constants.LOGIN_STATUS.EMAIL_ERROR);
        } else {
            if (user.getPassword().equals(Commons.hashPassword(password))) {
                mView.loginSuccess(user);
            } else {
                mView.loginFailed(Constants.LOGIN_STATUS.PASSWORD_ERROR);
            }
        }
    }
}

package com.xuanthongn.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.UserDao;
import com.xuanthongn.data.model.User;
import com.xuanthongn.ui.constract.ILoginConstract;
import com.xuanthongn.util.Constants;

public class LoginPresenter implements ILoginConstract.IPresenter {
    private ILoginConstract.IView mView;
    private AppDatabase db;
    public LoginPresenter(Context context){
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).build();
    }
    @Override
    public void setView(ILoginConstract.IView view) {
        mView = view;
    }

    @Override
    public void login(String email, String password) {
        UserDao userDao = db.userDao();
        User user = userDao.findByEmail(email);
        if(user == null){
            mView.loginFailed(Constants.LOGIN_STATUS.EMAIL_ERROR);
        }else{
            if(user.password.equals(password)){
                mView.loginSuccess();
            }else{
                mView.loginFailed(Constants.LOGIN_STATUS.PASSWORD_ERROR);
            }
        }
    }
}

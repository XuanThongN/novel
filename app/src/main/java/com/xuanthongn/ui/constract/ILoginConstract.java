package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.util.Constants;

public interface ILoginConstract {
    interface IView{
        void loginSuccess(UserDto user);
        void loginFailed(Constants.LOGIN_STATUS status);
    }
    interface IPresenter{
        void setView(IView view);
        void login(String email, String password);
    }
}

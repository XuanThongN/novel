package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.response_model.user.UserLoginResponseModel;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.data.model.user.UserLoginDto;
import com.xuanthongn.util.Constants;

public interface ILoginConstract {
    interface IView{
        void loginSuccess(UserLoginResponseModel user);
        void loginFailed(Constants.LOGIN_STATUS status);
    }
    interface IPresenter{
        void setView(IView view);
        void login(String username, String password);
    }
}

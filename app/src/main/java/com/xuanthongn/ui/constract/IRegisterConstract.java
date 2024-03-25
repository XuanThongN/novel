package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.UserDto;
import com.xuanthongn.util.Constants;

public interface IRegisterConstract {
    interface IView{
        void registerSuccess(UserDto user);
        void registerFailed(Constants.REGISTER_STATUS status);
    }
    interface IPresenter{
        void setView(IView view);
        void register(String email, String name, String password);
    }
}

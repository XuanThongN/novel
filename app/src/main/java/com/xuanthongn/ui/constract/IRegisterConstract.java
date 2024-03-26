package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.data.model.user.UserRegisterDto;
import com.xuanthongn.util.Constants;

public interface IRegisterConstract {
    interface IView{
        void registerSuccess(UserDto user);
        void registerFailed(Constants.REGISTER_STATUS status);
    }
    interface IPresenter{
        void setView(IView view);
        void register(UserRegisterDto input);
    }
}

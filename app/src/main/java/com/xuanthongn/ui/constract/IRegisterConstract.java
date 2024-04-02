package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.response_model.user.UserRegisterRequestModel;
import com.xuanthongn.data.model.response_model.user.UserRegisterResponseModel;
import com.xuanthongn.util.Constants;

public interface IRegisterConstract {
    interface IView{
        void registerSuccess(UserRegisterResponseModel user);
        void registerFailed(Constants.REGISTER_STATUS status);
    }
    interface IPresenter{
        void setView(IView view);
        void register(UserRegisterRequestModel input);
    }
}

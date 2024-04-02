package com.xuanthongn.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.response_model.comment.CommentRequestModel;
import com.xuanthongn.data.model.response_model.user.UserLoginResponseModel;
import com.xuanthongn.data.model.response_model.user.UserRegisterRequestModel;
import com.xuanthongn.data.model.response_model.user.UserRegisterResponseModel;
import com.xuanthongn.data.repository.UserRepository;
import com.xuanthongn.ui.constract.IRegisterConstract;
import com.xuanthongn.util.Commons;
import com.xuanthongn.util.Constants;
import com.xuanthongn.util.NovelTask;

public class RegisterPresenter implements IRegisterConstract.IPresenter {
    private IRegisterConstract.IView mView;
    private final AppDatabase db;
    private UserRepository userRepository;
    NovelTask novelTask;

    public RegisterPresenter(Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        userRepository = new UserRepository(db);
        novelTask = new NovelTask();
    }

    @Override
    public void setView(IRegisterConstract.IView view) {
        mView = view;
    }

    @Override
    public void register(UserRegisterRequestModel input) {
        UserRegisterResponseModel userRegisterResponseModel = new UserRegisterResponseModel();
        novelTask.getRegister(new Callback<UserRegisterResponseModel>() {
            @Override
            public void returnResult(UserRegisterResponseModel result) {
                if (Commons.isValidEmail(input.getEmail()) && userRegisterResponseModel == null) {
                    mView.registerSuccess(userRegisterResponseModel);
                } else if (Commons.isValidEmail(input.getEmail())) {
                    mView.registerFailed(Constants.REGISTER_STATUS.EMAIL_EXIST);
                } else {
                    mView.registerFailed(Constants.REGISTER_STATUS.INVALID_EMAIL);
                }
            }

            @Override
            public void returnError(String message) {

            }
        }, input);
    }
//    @Override
//    public void register(UserRegisterDto input) {
//        if (Commons.isValidEmail(input.getEmail())) {
//            UserDto userDto = userRepository.findByEmail(input.getEmail());
//            if (Commons.isValidEmail(input.getEmail()) && userDto == null) {
//                UserDto user = new UserDto(0, input.getName(), input.getEmail(), input.getPassword());
//                userRepository.insert(user);
//                mView.registerSuccess(user);
//            } else if (Commons.isValidEmail(input.getEmail())) {
//                mView.registerFailed(Constants.REGISTER_STATUS.EMAIL_EXIST);
//            } else {
//                mView.registerFailed(Constants.REGISTER_STATUS.INVALID_EMAIL);
//            }
//        }

}

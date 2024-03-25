package com.xuanthongn.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.model.UserDto;
import com.xuanthongn.data.repository.UserRepository;
import com.xuanthongn.ui.constract.IRegisterConstract;
import com.xuanthongn.util.Commons;
import com.xuanthongn.util.Constants;

public class RegisterPresenter implements IRegisterConstract.IPresenter {
    private IRegisterConstract.IView mView;
    private final AppDatabase db;
    private UserRepository userRepository;

    public RegisterPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        userRepository = new UserRepository(db);
    }

    @Override
    public void setView(IRegisterConstract.IView view) {
        mView = view;
    }

    @Override
    public void register(String email, String name, String password) {
        if (Commons.isValidEmail(email)) {
            UserDto user = new UserDto();
            user.setEmail(email);
            user.setName(name);
            user.setPassword(password);
            userRepository.insert(user);
            mView.registerSuccess(user);
        } else {
            mView.registerFailed(Constants.REGISTER_STATUS.INVALID_EMAIL);
        }
    }


}

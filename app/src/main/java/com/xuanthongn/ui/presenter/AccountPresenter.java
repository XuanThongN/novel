package com.xuanthongn.ui.presenter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.ui.constract.IAccountConstract;
import com.xuanthongn.util.Constants;

public class AccountPresenter implements IAccountConstract.IPresenter {
    private IAccountConstract.IView mView;
    private AppDatabase db;

    private Context context;

    public AccountPresenter(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).build();
    }

    @Override
    public void setView(IAccountConstract.IView view) {
        mView = view;
    }

    @Override
    public boolean getStoredLoginStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getBoolean(Constants.KEY_LOGIN_STATUS, false);

    }

    @Override
    public void getLoginInfo() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(Constants.KEY_NAME, null);
        String email = sharedPreferences.getString(Constants.KEY_EMAIL, null);
        mView.setLoginInfo(name, email);
    }

    @Override
    public void logout() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mView.setAccountLayout(false);
    }

}

package com.xuanthongn.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xuanthongn.R;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.ui.constract.IAccountConstract;
import com.xuanthongn.ui.presenter.AccountPresenter;
import com.xuanthongn.util.Constants;

public class ProfileActivity extends AppCompatActivity implements IAccountConstract.IView{
    IAccountConstract.IPresenter mPresenter;
    ImageButton btnBack;
    UserDto userDto;
    TextView profile_user_name;
    TextView profile_email;
    Context context;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_user_name = findViewById(R.id.profile_user_name);
        profile_email = findViewById(R.id.profile_email);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            finish();
        });
        mPresenter = new AccountPresenter(this);
        mPresenter.setView(this);
        mPresenter.getLoginInfo();

    }

    @Override
    public void setAccountLayout(boolean isLogin) {

    }

    @Override
    public void setLoginInfo(String name, String email) {
        if (profile_user_name != null && profile_email != null) {
            profile_user_name.setText(name);
            profile_email.setText(email);
        }
    }
}

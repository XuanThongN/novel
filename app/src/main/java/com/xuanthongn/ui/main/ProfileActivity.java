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
import com.xuanthongn.util.Constants;

public class ProfileActivity extends AppCompatActivity {

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
    }
}

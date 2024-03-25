package com.xuanthongn.ui.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xuanthongn.R;
import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.ui.constract.ILoginConstract;
import com.xuanthongn.ui.presenter.LoginPresenter;
import com.xuanthongn.util.Constants;

public class LoginActivity extends BaseActivity implements ILoginConstract.IView {
    private ILoginConstract.IPresenter mPresenter;
    Button btnLogin;
    EditText edtEmail;
    EditText edtPassword;
    TextView textViewBack;
    TextView btn_go_to_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter(this);
        mPresenter.setView(this);

        initGUI();
    }

    private void initGUI() {
        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btn_login);
        textViewBack = findViewById(R.id.textViewBack);
        btn_go_to_register = findViewById(R.id.tv_go_to_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                mPresenter.login(email, password);
            }
        });
        textViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_go_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Go to register activity
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void loginSuccess(UserDto user) {
        // Save login information to shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Constants.KEY_LOGIN_STATUS, true);
        editor.putString(Constants.KEY_EMAIL, user.getEmail().trim());
        editor.apply();
        // Navigate to main activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void loginFailed(Constants.LOGIN_STATUS status) {
        switch (status) {
            case EMAIL_ERROR:
                Toast.makeText(this, "Email không tồn tại trong hệ thống.", Toast.LENGTH_LONG).show();
                break;
            case PASSWORD_ERROR:
                Toast.makeText(this, "Mật khẩu chưa đúng", Toast.LENGTH_LONG).show();
                break;
        }
    }

}
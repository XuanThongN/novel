package com.xuanthongn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.ui.constract.ILoginConstract;
import com.xuanthongn.ui.presenter.LoginPresenter;
import com.xuanthongn.util.Constants;

public class LoginActivity extends BaseActivity implements ILoginConstract.IView {
    private ILoginConstract.IPresenter mPresenter;
    Button btnLogin;
    EditText edtEmail;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter(this);
        mPresenter.setView(this);

        initGUI();
    }

    private void initGUI() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                mPresenter.login(email, password);
            }
        });
    }
    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed(Constants.LOGIN_STATUS status) {

    }

}
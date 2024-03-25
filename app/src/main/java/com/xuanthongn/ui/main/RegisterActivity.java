package com.xuanthongn.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xuanthongn.R;
import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.data.model.user.UserRegisterDto;
import com.xuanthongn.ui.constract.IRegisterConstract;
import com.xuanthongn.ui.presenter.RegisterPresenter;
import com.xuanthongn.util.Commons;
import com.xuanthongn.util.Constants;

public class RegisterActivity extends BaseActivity implements IRegisterConstract.IView {

    private IRegisterConstract.IPresenter mPresenter;
    private EditText edtEmail, edtName, edtPassword, edtRePassword;
    private CheckBox checkBoxAccept;
    private Button btnRegister;
    private TextView tvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Replace with your layout resource ID
        initGUI();
        mPresenter = new RegisterPresenter(this);
        mPresenter.setView(this);
    }

    private void initGUI() {
        edtEmail = findViewById(R.id.edtEmail);
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        edtRePassword = findViewById(R.id.edtRePassword);
        checkBoxAccept = findViewById(R.id.checkBoxAccept);
        tvBack = findViewById(R.id.tvBack);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    String email = edtEmail.getText().toString().trim();
                    String name = edtName.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();
                    UserRegisterDto userRegisterDto = new UserRegisterDto(name, email, password);
                    mPresenter.register(userRegisterDto);
                }
            }
        });

        checkBoxAccept.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                btnRegister.setEnabled(true);
            } else {
                btnRegister.setEnabled(false);
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean validateForm() {
        boolean isValid = true;

        String email = edtEmail.getText().toString();
        if (email.isEmpty() || !Commons.isValidEmail(email)) {
            isValid = false;
            edtEmail.setError("Email chưa đúng định dạng."); // Set error message

        }

        String password = edtPassword.getText().toString();
        if (password.isEmpty() || password.length() < 8) {
            isValid = false;
            edtPassword.setError("Mật khẩu phải có ít nhất 8 ký tự.");
        }

        String retypedPassword = edtRePassword.getText().toString();
        if (!password.equals(retypedPassword)) {
            isValid = false;
            edtRePassword.setError("Mật khẩu không khớp.");
        }

        return isValid;
    }

    @Override
    public void registerSuccess(UserDto user) {
        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void registerFailed(Constants.REGISTER_STATUS status) {
        switch (status) {
            case INVALID_EMAIL:
                Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_LONG).show();
                break;
            case EMAIL_EXIST:
                Toast.makeText(this, "Email đã được sử dụng.", Toast.LENGTH_LONG).show();
                break;
            case NAME_INVALID:
                Toast.makeText(this, "Tên không hợp lệ.", Toast.LENGTH_LONG).show();
                break;
            case PASSWORD_INVALID:
                Toast.makeText(this, "Mật khẩu không hợp lệ.", Toast.LENGTH_LONG).show();
                break;

        }

    }
}

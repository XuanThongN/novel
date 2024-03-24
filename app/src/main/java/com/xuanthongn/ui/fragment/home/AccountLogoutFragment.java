package com.xuanthongn.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xuanthongn.R;
import com.xuanthongn.ui.constract.IAccountConstract;
import com.xuanthongn.ui.main.LoginActivity;
import com.xuanthongn.ui.main.ProfileActivity;
import com.xuanthongn.ui.presenter.AccountPresenter;

import io.reactivex.rxjava3.annotations.NonNull;

public class AccountLogoutFragment extends Fragment {
    Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_logout, container, false);
        btnLogin = view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }

        });

        return view;
    }
}

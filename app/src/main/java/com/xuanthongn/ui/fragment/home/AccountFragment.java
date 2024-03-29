package com.xuanthongn.ui.fragment.home;

import static com.xuanthongn.R.id.profile_detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xuanthongn.R;
import com.xuanthongn.ui.constract.IAccountConstract;
import com.xuanthongn.ui.main.LoginActivity;
import com.xuanthongn.ui.main.ProfileActivity;
import com.xuanthongn.ui.presenter.AccountPresenter;
import com.xuanthongn.ui.presenter.HomePresenter;

import io.reactivex.rxjava3.annotations.NonNull;

public class AccountFragment extends Fragment implements IAccountConstract.IView {
    IAccountConstract.IPresenter mPresenter;
    LinearLayout profile_detail;
    Button btnLogout;
    private TextView usernameTextView;
    private TextView emailTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        profile_detail = view.findViewById(R.id.profile_detail);
        btnLogout = view.findViewById(R.id.btn_logout);
        usernameTextView = view.findViewById(R.id.name_account);
        emailTextView = view.findViewById(R.id.email_account);
        profile_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }

        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.logout();
            }

        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new AccountPresenter(getContext());
        mPresenter.setView(this);
        mPresenter.getLoginInfo();

    }

    @Override
    public void setAccountLayout(boolean isLogin) {
        // Create an instance of the AccountLogoutFragment
        AccountLogoutFragment otherFragment = new AccountLogoutFragment();

        // Get the FragmentManager
        FragmentManager fragmentManager = getParentFragmentManager();

        // Start a FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the AccountLogoutFragment
        fragmentTransaction.replace(R.id.fragment_container, otherFragment);

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }
    public void setLoginInfo(String name, String email) {
        // Kiểm tra xem TextView đã được khởi tạo chưa trước khi thiết lập giá trị
        if (usernameTextView != null && emailTextView != null) {
            usernameTextView.setText(name);
            emailTextView.setText(email);
        }
    }

}

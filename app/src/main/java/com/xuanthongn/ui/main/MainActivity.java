package com.xuanthongn.ui.main;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.model.Model;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xuanthongn.R;
import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.entity.User;
import com.xuanthongn.data.model.CategoryItem;
import com.xuanthongn.data.entity.Product;
import com.xuanthongn.data.model.UserDto;
import com.xuanthongn.data.repository.UserRepository;
import com.xuanthongn.ui.constract.IMainConstract;
import com.xuanthongn.ui.fragment.home.AccountFragment;
import com.xuanthongn.ui.fragment.home.AccountLogoutFragment;
import com.xuanthongn.ui.fragment.home.BookmarkFragment;
import com.xuanthongn.ui.fragment.home.HomeFragment;
import com.xuanthongn.ui.presenter.MainPresenter;
import com.xuanthongn.util.Constants;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MainActivity extends BaseActivity implements IMainConstract.IView {
    private RecyclerView mRvHotProduct;
    private IMainConstract.IPresenter mPresenter;
    private List<CategoryItem> categories;
    private GridView categoryGrid;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGUI();
        mPresenter = new MainPresenter(this);
        mPresenter.setView(this);


    }

    private void initGUI() {

//        mRvHotProduct = findViewById(R.id.rv_hot_product);
        //Bottom Navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment(); // Replace with HomeFragment.class for older versions
                    break;
                case R.id.navigation_bookmark:
                    selectedFragment = new BookmarkFragment(); // Replace with BookmarksFragment.class for older versions
                    break;
                case R.id.navigation_account:
                    if (mPresenter.getStoredLoginStatus()) {
                        selectedFragment = new AccountFragment();
                    } else {
                        selectedFragment = new AccountLogoutFragment(); // Replace with AccountFragment.class for older versions
                    }
                    break;
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }


}
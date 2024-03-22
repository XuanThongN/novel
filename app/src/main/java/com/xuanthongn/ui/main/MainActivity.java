package com.xuanthongn.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.xuanthongn.R;
import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.data.model.CategoryItem;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.NovelRecommend;
import com.xuanthongn.data.entity.Product;
import com.xuanthongn.ui.adapter.CategoryItemAdapter;
import com.xuanthongn.ui.adapter.NovelContinueReadingAdapter;
import com.xuanthongn.ui.adapter.NovelRecommendAdapter;
import com.xuanthongn.ui.constract.IMainConstract;
import com.xuanthongn.ui.fragment.novel_details_fragments.home.AccountFragment;
import com.xuanthongn.ui.fragment.novel_details_fragments.home.BookmarkFragment;
import com.xuanthongn.ui.fragment.novel_details_fragments.home.HomeFragment;
import com.xuanthongn.ui.presenter.MainPresenter;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        mPresenter = new MainPresenter(this);
        mPresenter.setView(this);

        initGUI();

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
                    selectedFragment = new AccountFragment(); // Replace with AccountFragment.class for older versions
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

    private void initGUI() {

//        mRvHotProduct = findViewById(R.id.rv_hot_product);
    }

    @Override
    public void setHotProductsToView(List<Product> productList) {

    }


}
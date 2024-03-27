package com.xuanthongn.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.xuanthongn.R;
import com.xuanthongn.data.dto.NovelDto;
import com.xuanthongn.ui.adapter.NovelDetailsPagerAdapter;
import com.xuanthongn.ui.adapter.NovelSearchAdapter;
import com.xuanthongn.ui.constract.ISearchConstract;
import com.xuanthongn.ui.presenter.SearchNovelPresenter;

import java.util.List;

public class NovelPageSearchActivity extends  AppCompatActivity implements ISearchConstract.IView {

    ISearchConstract.IPresenter mPresenter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    NovelSearchAdapter myViewPagerAdapter;
    LinearLayout btnBack;
    EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_search);
        mPresenter = new SearchNovelPresenter(this);
        mPresenter.setView(this);

        tabLayout = findViewById(R.id.tab_layout_search_page_novel);
        viewPager2 =findViewById(R.id.view_pager_search_page_novel);


        btnBack =findViewById(R.id.btn_back_search);
        edtSearch = findViewById(R.id.edt_search);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This finishes the current activity and returns to the previous one
                System.out.println("OK");
                finish();
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.searchNovel(s.toString());


            }
        });
    }

    @Override
    public void showResults(List<NovelDto> novels) {
        myViewPagerAdapter = new NovelSearchAdapter(this, novels);
        viewPager2.setAdapter(myViewPagerAdapter);
    }
}
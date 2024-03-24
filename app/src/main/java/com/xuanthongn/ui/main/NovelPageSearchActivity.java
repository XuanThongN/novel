package com.xuanthongn.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.xuanthongn.R;
import com.xuanthongn.ui.adapter.NovelDetailsPagerAdapter;
import com.xuanthongn.ui.adapter.NovelSearchAdapter;

public class NovelPageSearchActivity extends  AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    NovelSearchAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_search);

        tabLayout = findViewById(R.id.tab_layout_search_page_novel);
        viewPager2 =findViewById(R.id.view_pager_search_page_novel);
        myViewPagerAdapter = new NovelSearchAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);

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


    }
}
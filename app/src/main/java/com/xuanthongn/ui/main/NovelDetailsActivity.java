package com.xuanthongn.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.xuanthongn.R;
import com.xuanthongn.ui.adapter.NovelDetailsPagerAdapter;

public class NovelDetailsActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    NovelDetailsPagerAdapter myViewPagerAdapter;
    LinearLayout btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_details);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 =findViewById(R.id.view_pager);

        btnBack =findViewById(R.id.btn_back);

        myViewPagerAdapter = new NovelDetailsPagerAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);
        String novelName = getIntent().getStringExtra("novel_name");

        // Hiển thị dữ liệu của truyện trên giao diện
//        TextView novelNameTextView = findViewById(R.id.Item_Detail);
//        novelNameTextView.setText(novelName);

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

    }
}
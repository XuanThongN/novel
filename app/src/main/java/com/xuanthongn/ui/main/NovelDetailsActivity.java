package com.xuanthongn.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.xuanthongn.R;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.ui.adapter.NovelDetailsPagerAdapter;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.ui.fragment.novel_details_fragments.InformationFragment;

public class NovelDetailsActivity extends AppCompatActivity implements INovelDetailConstract.IView {
    private INovelDetailConstract.IPresenter mPresenter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    NovelDetailsPagerAdapter myViewPagerAdapter;
    LinearLayout btnBack;
    LinearLayout btnRead;
    NovelDto novel;
    ImageView novelImage;
    TextView tNovelName;
    LinearLayout novelBackground;
    Drawable newBackground;

    // Declaring fragment manager from making data
    // transactions using the custom fragment
    final androidx.fragment.app
            .FragmentManager mFragmentManager
            = getSupportFragmentManager();
    final androidx.fragment.app
            .FragmentTransaction mFragmentTransaction
            = mFragmentManager.beginTransaction();
    final InformationFragment mFragment
            = new InformationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_details);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        btnBack = findViewById(R.id.btn_back);
        btnRead = findViewById(R.id.btn_read_novel);
        tNovelName = findViewById(R.id.novel_detail_name);
//        novelImage = findViewById(R.id.novel_image);
        myViewPagerAdapter = new NovelDetailsPagerAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);
        novelBackground = findViewById(R.id.novel_background);



        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Thông Tin");
                            break;
                        case 1:
                            tab.setText("Chương");
                            break;
                    }
                }).attach();
        Intent intent = getIntent();
        NovelDto novel = (NovelDto) intent.getSerializableExtra("novel");

        // Send data to child fragments
        setNovel(novel);

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
                finish();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, NovelReadActivity.class);
                // Pass data if needed
                context.startActivity(intent);

            }
        });

        LinearLayout novelBackground = findViewById(R.id.novel_background);
        if (novel != null) {
            tNovelName.setText(novel.getName());
            Glide.with(this).load(novel.getImageUrl()).into(new CustomTarget<Drawable>() {
                @Override
                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        novelBackground.setBackground(resource);
                    } else {
                        novelBackground.setBackgroundDrawable(resource);
                    }
                }
                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {
                    displayError("Xử lý khi việc tải hình ảnh đã bị hủy bỏ"); }
            });
        }

    }

    public NovelDto getNovel() {
        return novel;
    }

    public void setNovel(NovelDto novel) {
        this.novel = novel;
    }

    @Override
    public void displayNovelDetails(NovelDto novel) {

    }

    @Override
    public void displayError(String errorMessage) {

    }


}
package com.xuanthongn.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.xuanthongn.R;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelCreateDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.ui.adapter.NovelDetailsPagerAdapter;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.ui.fragment.novel_details_fragments.InformationFragment;

import java.io.Serializable;
import java.util.List;


public class NovelDetailsActivity extends AppCompatActivity implements INovelDetailConstract.IView {
    private INovelDetailConstract.IPresenter mPresenter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    NovelDetailsPagerAdapter myViewPagerAdapter;
    LinearLayout btnBack;
    LinearLayout btnRead;
    NovelDto novel;
    NovelCreateDto novelCreateDto;
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

    public NovelDetailsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_details);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        btnBack = findViewById(R.id.btn_back);
        btnRead = findViewById(R.id.btn_read_novel);
        tNovelName = findViewById(R.id.novel_detail_name);
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
                // Truyền tất cả dữ liệu của cuốn truyện qua Intent
                intent.putExtra("novel", (Serializable)
                        new NovelDto(novel.getId()));
                context.startActivity(intent);
            }
        });

        LinearLayout novelBackground = findViewById(R.id.novel_background);

        if (novel != null) {
            tNovelName.setText(novel.getName());
            Glide.with(this)
                    .load(novel.getImageUrl())
                    .into(new CustomTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            // Tạo một bộ lọc ColorMatrix để điều chỉnh độ mờ của hình ảnh
                            ColorMatrix colorMatrix = new ColorMatrix();
                            colorMatrix.setScale(1, 1, 1, 0.4f); // Giảm độ trong suất của hình ảnh

                            // Áp dụng bộ lọc ColorMatrix vào hình ảnh
                            resource.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                novelBackground.setBackground(resource);
                            } else {
                                novelBackground.setBackgroundDrawable(resource);
                            }
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                            displayError("Xử lý khi việc tải hình ảnh đã bị hủy bỏ");
                        }
                    });
        }

    }

    public NovelDto getNovel() {
        return novel;
    }


    public NovelCreateDto getNovelCreateDto() {
        return novelCreateDto;
    }

    public void setNovelCreateDto(NovelCreateDto novelCreateDto) {
        this.novelCreateDto = novelCreateDto;
    }

    public void setNovel(NovelDto novel) {
        this.novel = novel;
    }

    @Override
    public void displayError(String errorMessage) {
    }

    @Override
    public void showLatestNovels(List<NovelRecommendDto> novels) {

    }

    @Override
    public void showChapters(List<ChapterDto> chapters) {

    }

    @Override
    public void showChaptersNew(List<ChapterDto> chapters) {

    }

    @Override
    public void showTotalChapterCount(int count) {

    }

}
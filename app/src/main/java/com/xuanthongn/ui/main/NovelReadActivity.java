package com.xuanthongn.ui.main;

import android.annotation.SuppressLint;
import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.repository.ChapterRepository;
import com.xuanthongn.ui.adapter.NovelDetailsChaperListAdapter;
import com.xuanthongn.ui.adapter.NovelReadingChapterAdapter;
import com.xuanthongn.ui.constract.IDetailChapterConstract;
import com.xuanthongn.ui.presenter.ChapterDetailPresenter;

import java.util.List;

public class NovelReadActivity extends AppCompatActivity implements IDetailChapterConstract.IView {
    IDetailChapterConstract.IPresenter mPresenter;
    LinearLayout btnBack;
    TextView textContentChapter;
    TextView textTitleChapter;
    RecyclerView recyclerView;
    private int novelId;
    private int currentChapterIndex = 0;

    public NovelDto getChapterDto() {
        return chapterDto;
    }

    public void setChapterDto(NovelDto chapterDto) {
        this.chapterDto = chapterDto;
    }

    NovelDto chapterDto;
    RelativeLayout rootLayout;
    LinearLayout topControl;
    RelativeLayout bottomControl;
    private final Handler handler = new Handler();

    private final Runnable hideControlsRunnable = new Runnable() {
        @Override
        public void run() {
            topControl.setVisibility(View.INVISIBLE);
            bottomControl.setVisibility(View.INVISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_read);
        initGUI();
        mPresenter = new ChapterDetailPresenter(this);
        mPresenter.setView(this);
        Intent intent = getIntent();
        NovelDto novel = (NovelDto) intent.getSerializableExtra("novel");
        if (novel != null) {
            novelId = novel.getId();
            mPresenter.getDetailChapter(novelId);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);

    }

    //    @SuppressLint("ClickableViewAccessibility")
    @SuppressLint("ClickableViewAccessibility")
    public void initGUI() {
        recyclerView = findViewById(R.id.rv_continue_novel_reading_chapter_list);
        btnBack = findViewById(R.id.btn_readback);
        textContentChapter = findViewById(R.id.novel_content_edit);
        textTitleChapter = findViewById(R.id.novel_content);
        rootLayout = findViewById(R.id.root_layout);
        topControl = findViewById(R.id.top_control);
        bottomControl = findViewById(R.id.bottom_control);
        // Hide controls after 2 seconds
        handler.postDelayed(hideControlsRunnable, 2000);



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Xu ly su kien cac nut dieu khien tren man hinh doc truyen
        Button nextButton = findViewById(R.id.btn_next);
        Button previousButton = findViewById(R.id.btn_previous);

//        Xu ly su kien khi click vao nut next va previous
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentChapterIndex < recyclerView.getAdapter().getItemCount() - 1) {
                    currentChapterIndex++;
                    recyclerView.smoothScrollToPosition(currentChapterIndex);
                } else {
                    Toast.makeText(NovelReadActivity.this, "Bạn đang ở Chương cuối cùng.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentChapterIndex > 0) {
                    currentChapterIndex--;
                    recyclerView.smoothScrollToPosition(currentChapterIndex);
                } else {
                    Toast.makeText(NovelReadActivity.this, "Bạn đang mở chương đầu tiên.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showContent(List<ChapterDto> chapters) {
        recyclerView.setAdapter(new NovelReadingChapterAdapter(this, chapters));
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void showControls() {
        topControl.setVisibility(View.VISIBLE);
        bottomControl.setVisibility(View.VISIBLE);
        // Re-schedule hiding controls after 2 seconds
        handler.removeCallbacks(hideControlsRunnable);
        handler.postDelayed(hideControlsRunnable, 2000);
    }
}

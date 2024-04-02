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
import androidx.recyclerview.widget.PagerSnapHelper;
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
    TextView textNovelTitle;
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
    Button nextButton;
    Button previousButton;
    private final Handler handler = new Handler();

    private final Runnable hideControlsRunnable = new Runnable() {
        @Override
        public void run() {
            topControl.setVisibility(View.GONE);
            bottomControl.setVisibility(View.GONE);
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
            textNovelTitle.setText(novel.getName());

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);

    }

    //    @SuppressLint("ClickableViewAccessibility")
    public void initGUI() {
        recyclerView = findViewById(R.id.rv_continue_novel_reading_chapter_list);
        btnBack = findViewById(R.id.btn_readback);
        textContentChapter = findViewById(R.id.novel_content_edit);
        textTitleChapter = findViewById(R.id.novel_content);
        rootLayout = findViewById(R.id.root_layout);
        topControl = findViewById(R.id.top_control);
        bottomControl = findViewById(R.id.bottom_control);
        textNovelTitle = findViewById(R.id.novel_title);
        // Hide controls after 2 seconds
        handler.postDelayed(hideControlsRunnable, 2000);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nextButton = findViewById(R.id.btn_next);
        previousButton = findViewById(R.id.btn_previous);

    }

    // Xu ly su kien cac nut dieu khien tren man hinh doc truyen
    private void setListenerForButtonControl() {

//        Xu ly su kien khi click vao nut next va previous
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextChapter();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousChapter();
            }
        });
    }

    // Method to navigate to the next chapter
    private void nextChapter() {
        if (currentChapterIndex < (recyclerView.getAdapter().getItemCount()) - 1) {
            currentChapterIndex++;
            ((NovelReadingChapterAdapter) recyclerView.getAdapter()).setCurrentItemIndex(currentChapterIndex);
            recyclerView.getAdapter().notifyDataSetChanged();
        } else {
            Toast.makeText(NovelReadActivity.this, "Bạn đang ở Chương cuối cùng.", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to navigate to the previous chapter
    private void previousChapter() {
        if (currentChapterIndex > 0) {
            currentChapterIndex--;
            ((NovelReadingChapterAdapter) recyclerView.getAdapter()).setCurrentItemIndex(currentChapterIndex);
            recyclerView.getAdapter().notifyDataSetChanged();
        } else {
            Toast.makeText(NovelReadActivity.this, "Bạn đang mở chương đầu tiên.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showContent(List<ChapterDto> chapters) {
        NovelReadingChapterAdapter adapter = new NovelReadingChapterAdapter(this, chapters);
//        new PagerSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
        setListenerForButtonControl();
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

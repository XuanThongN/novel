package com.xuanthongn.ui.main;

import android.annotation.SuppressLint;
import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xuanthongn.R;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.repository.ChapterRepository;
import com.xuanthongn.ui.constract.IDetailChapterConstract;
import com.xuanthongn.ui.presenter.ChapterDetailPresenter;

public class NovelReadActivity extends AppCompatActivity implements IDetailChapterConstract.IView {
    IDetailChapterConstract.IPresenter mPresenter;
    LinearLayout btnBack;
    TextView textContentChapter;
    TextView textTitleChapter;

    private Handler handler = new Handler();

    private Runnable hideControlsRunnable = new Runnable() {
        @Override
        public void run() {
            findViewById(R.id.top_control).setVisibility(View.GONE);
            findViewById(R.id.bottom_control).setVisibility(View.GONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_read);
        initGUI();
        mPresenter = new ChapterDetailPresenter(this);
        mPresenter.setView(this);
        mPresenter.getDetailChapter(1);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);

    }

    @SuppressLint("ClickableViewAccessibility")
    public void initGUI() {
        btnBack = findViewById(R.id.btn_readback);
        textContentChapter = findViewById(R.id.novel_content_edit);
        textTitleChapter = findViewById(R.id.novel_content);
        // Hide controls after 2 seconds
        handler.postDelayed(hideControlsRunnable, 2000);

        // Show controls when clicked anywhere on the screen
        ScrollView mainLayout = findViewById(R.id.novel_root_content); // Replace with your actual root layout ID
        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            private float startY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        float endY = event.getY();
                        if (Math.abs(endY - startY) < 10) { // Adjust the sensitivity as needed
                            findViewById(R.id.top_control).setVisibility(View.VISIBLE);
                            findViewById(R.id.bottom_control).setVisibility(View.VISIBLE);
                            // You can optionally reset the hide timer here if needed
                            handler.removeCallbacks(hideControlsRunnable);
                            handler.postDelayed(hideControlsRunnable, 2000); //
                        }
                        break;
                }
                return false;
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showContent(ChapterDto chapterDto) {
        // Hiển thị nội dung của chapter trong TextView textContentChapter
        textTitleChapter.setText(chapterDto.getName());
        textContentChapter.setText(chapterDto.getContent());

    }

}

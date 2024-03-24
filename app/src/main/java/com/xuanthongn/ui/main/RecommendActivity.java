package com.xuanthongn.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.NovelRecommend;
import com.xuanthongn.ui.adapter.NovelRecommendBtvAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecommendActivity extends AppCompatActivity {
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_recommended);

        btnBack = findViewById(R.id.btn_back_recommend);
        initGUI();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // This finishes the current activity and returns to the previous one
                System.out.println("OK");
                finish();

            }
        });
    }

    private void initGUI() {
        Context context = this;

        // Tìm RecyclerView từ layout của Activity
        RecyclerView rvContinueChapterList1 = findViewById(R.id.rv_novel_recommend1);
        List<NovelRecommend> chapterList1 = new ArrayList<>();
        chapterList1.add(new NovelRecommend(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList1.add(new NovelRecommend(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList1.add(new NovelRecommend(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList1.add(new NovelRecommend(4, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList1.add(new NovelRecommend(5, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));

        rvContinueChapterList1.setAdapter(new NovelRecommendBtvAdapter(context, chapterList1));


        RecyclerView rvContinueChapterList2 = findViewById(R.id.rv_novel_recommend2);
        List<NovelRecommend> chapterList2 = new ArrayList<>();
        chapterList2.add(new NovelRecommend(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList2.add(new NovelRecommend(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList2.add(new NovelRecommend(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList2.add(new NovelRecommend(4, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList2.add(new NovelRecommend(5, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));

        rvContinueChapterList2.setAdapter(new NovelRecommendBtvAdapter(context, chapterList2));

        RecyclerView rvContinueChapterList3 = findViewById(R.id.rv_novel_recommend3);
        List<NovelRecommend> chapterList3 = new ArrayList<>();
        chapterList3.add(new NovelRecommend(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList3.add(new NovelRecommend(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList3.add(new NovelRecommend(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList3.add(new NovelRecommend(4, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));
        chapterList3.add(new NovelRecommend(5, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hệ thống thánh lười Truyền Thuyết"));

        rvContinueChapterList3.setAdapter(new NovelRecommendBtvAdapter(context, chapterList3));

    }
}

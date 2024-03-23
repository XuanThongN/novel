package com.xuanthongn.ui.fragment.novel_details_fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuanthongn.R;
import com.xuanthongn.data.model.Category;
import com.xuanthongn.data.model.Chapter;
import com.xuanthongn.ui.adapter.CategoryNovelItemAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsChaperListAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsChaperNewAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChapterFragment extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);

        initGUI(view);
        // Inflate the layout for this fragment
        return view;
    }

    private void initGUI(View view) {
        Context context = this.getContext();

//        Truyền dữ liệu vào list truyện
        RecyclerView rvContinueChapterList = view.findViewById(R.id.rv_continue_novel_chapter_list);
        List<Chapter> chapterList = new ArrayList<>();
        chapterList.add(new Chapter(1, "Truyền Thuyết", new Date(102, 1, 12)));
        chapterList.add(new Chapter(2, "Truyền Thuyết", new Date(102, 1, 12)));
        chapterList.add(new Chapter(3, "Truyền Thuyết", new Date(102, 1, 12)));
        chapterList.add(new Chapter(4, "Truyền Thuyết", new Date(102, 1, 12)));


        rvContinueChapterList.setAdapter(new NovelDetailsChaperListAdapter(context, chapterList));


        RecyclerView rvContinueChapterNew = view.findViewById(R.id.rv_continue_novel_chapter_new);
        List<Chapter> chapterNew = new ArrayList<>();
        chapterNew.add(new Chapter(1, "Dạng..."));
        chapterNew.add(new Chapter(2, "Dạng..."));
        chapterNew.add(new Chapter(3, "Dạng..."));
        chapterNew.add(new Chapter(4, "Dạng..."));

        rvContinueChapterNew.setLayoutManager(new GridLayoutManager(context, 2));
        rvContinueChapterNew.setAdapter(new NovelDetailsChaperNewAdapter(context, chapterNew));




    }
}
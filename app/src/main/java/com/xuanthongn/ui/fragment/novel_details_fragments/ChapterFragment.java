package com.xuanthongn.ui.fragment.novel_details_fragments;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuanthongn.R;
import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.model.Category;
import com.xuanthongn.data.model.Chapter;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.ui.adapter.CategoryNovelItemAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsChaperListAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsChaperNewAdapter;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.ui.presenter.NovelDetailPresenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;

public class ChapterFragment extends Fragment implements INovelDetailConstract.IView {
    private INovelDetailConstract.IPresenter mPresenter;
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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new NovelDetailPresenter(getContext());
        mPresenter.setView(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            NovelRecommendDto novel = (NovelRecommendDto) arguments.getSerializable("novel");
            if (novel != null) {
                // Sử dụng dữ liệu của cuốn truyện để hiển thị thông tin chi tiết
                // Ví dụ: novel.getName(), novel.getAuthor(),...
            }
        }
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

    @Override
    public void displayError(String errorMessage) {
    }

    @Override
    public void showLatestNovels(List<NovelDto> novels) {
    }
}
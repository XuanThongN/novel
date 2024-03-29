package com.xuanthongn.ui.fragment.novel_details_fragments;

import androidx.annotation.NonNull;
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
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.repository.ChapterRepository;
import com.xuanthongn.ui.adapter.CategoryNovelItemAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsChaperListAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsChaperNewAdapter;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.ui.main.NovelDetailsActivity;
import com.xuanthongn.ui.presenter.NovelDetailPresenter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class ChapterFragment extends Fragment implements INovelDetailConstract.IView {
    private INovelDetailConstract.IPresenter mPresenter;
    RecyclerView rvContinueChapterNew;
    RecyclerView rvContinueChapterNewList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);
        rvContinueChapterNew = view.findViewById(R.id.rv_continue_novel_chapter_new);
        rvContinueChapterNewList = view.findViewById(R.id.rv_continue_novel_chapter_list);
        initGUI(view);
        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new NovelDetailPresenter(view.getContext());
        mPresenter.setView(this);
        NovelDto novel = getNovelFromActivity();
        if (novel != null) {
            mPresenter.getAllChaptersByNovelId(novel.getId());
            mPresenter.getAllChaptersByNovelNew(novel.getId());
        }
    }

    private NovelDto getNovelFromActivity() {
        if (getActivity() instanceof NovelDetailsActivity) {
            return ((NovelDetailsActivity) getActivity()).getNovel();
        }
        return null;
    }

    private void initGUI(View view) {
        Context context = this.getContext();
    }

    @Override
    public void displayError(String errorMessage) {
    }

    @Override
    public void showLatestNovels(List<NovelRecommendDto> novels) {

    }

    @Override
    public void showChapters(List<ChapterDto> chapters) {
        rvContinueChapterNewList.setAdapter(new NovelDetailsChaperListAdapter(this.getContext(), chapters));
    }

    @Override
    public void showChaptersNew(List<ChapterDto> chapters) {
        Context context = this.getContext();
        rvContinueChapterNew.setLayoutManager(new GridLayoutManager(context, 2));
        rvContinueChapterNew.setAdapter(new NovelDetailsChaperNewAdapter(this.getContext(), chapters));

    }

}
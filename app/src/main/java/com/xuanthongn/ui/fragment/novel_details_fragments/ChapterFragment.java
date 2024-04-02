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
import android.widget.TextView;
import android.widget.Toast;

import com.xuanthongn.R;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;
import com.xuanthongn.ui.adapter.NovelDetailsChaperListAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsChaperNewAdapter;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.ui.main.NovelDetailsActivity;
import com.xuanthongn.ui.presenter.NovelDetailPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ChapterFragment extends Fragment implements INovelDetailConstract.IView {
    private INovelDetailConstract.IPresenter mPresenter;
    RecyclerView rvChapterNew;
    RecyclerView rvChapterList;
    TextView tvSort;
    List<ChapterDto> chapters = new ArrayList<>();
    private boolean isSortAsc = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);
        // Inflate the layout for this fragment
        initGUI(view);
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
            mPresenter.getNewestChaptersByNovelId(novel.getId());
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
        rvChapterNew = view.findViewById(R.id.rv_novel_chapter_new);
        rvChapterList = view.findViewById(R.id.rv_novel_chapter_list);
        tvSort = view.findViewById(R.id.tv_sort);
    }

    private void sortData() {
        tvSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSortAsc) {
                    // Sort in ascending order
                    chapters.sort(new Comparator<ChapterDto>() {
                        @Override
                        public int compare(ChapterDto c1, ChapterDto c2) {
                            return c1.getChapterId() - c2.getChapterId();
                        }
                    });
                    tvSort.setText("Mới nhất");
                } else {
                    // Sort in descending order
                    chapters.sort(new Comparator<ChapterDto>() {
                        @Override
                        public int compare(ChapterDto c1, ChapterDto c2) {
                            return c2.getChapterId() - c1.getChapterId();
                        }
                    });
                    tvSort.setText("Cũ nhất");

                }
                rvChapterList.getAdapter().notifyDataSetChanged();
                isSortAsc = !isSortAsc;
            }
        });

    }

    public List<ChapterDto> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterDto> chapters) {
        this.chapters = chapters;
    }

    @Override
    public void displayError(String errorMessage) {
        Toast.makeText(this.getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLatestNovels(List<NovelRecommendDto> novels) {

    }

    @Override
    public void showChapters(List<ChapterDto> chapters) {
        setChapters(chapters);
        rvChapterList.setAdapter(new NovelDetailsChaperListAdapter(this.getContext(), this.chapters));
        sortData();
    }

    @Override
    public void showChaptersNew(List<ChapterDto> chapters) {
        Context context = this.getContext();
        rvChapterNew.setLayoutManager(new GridLayoutManager(context, 2));
        rvChapterNew.setAdapter(new NovelDetailsChaperNewAdapter(this.getContext(), chapters));

    }

    @Override
    public void showTotalChapterCount(int count) {

    }

    @Override
    public void showComments(List<CommentsResponseModel> result) {

    }

    @Override
    public void addCommentToList(CommentsResponseModel result) {

    }

}
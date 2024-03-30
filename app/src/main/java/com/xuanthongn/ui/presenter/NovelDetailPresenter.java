package com.xuanthongn.ui.presenter;


import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.data.repository.ChapterRepository;
import com.xuanthongn.data.repository.NovelRepository;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.util.Constants;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NovelDetailPresenter implements INovelDetailConstract.IPresenter {
    private INovelDetailConstract.IView mView;

    CategoryRepository mCategoryRepository;
    AppDatabase db;
    NovelRepository mNovelRepository;
    ChapterRepository mChapterResponsitory;


    private Context context;

    public NovelDetailPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        this.context = context;
        mCategoryRepository = new CategoryRepository(db);
        mNovelRepository = new NovelRepository(db);
        mChapterResponsitory = new ChapterRepository(db);
    }

    @Override
    public void setView(INovelDetailConstract.IView view) {
        mView = view;
    }

    @Override
    public void getLatestNovelsByCategory(int categoryId) {
        List<NovelRecommendDto> latestNovels = mNovelRepository.findLatestNovelsByCategory(categoryId);
        mView.showLatestNovels(latestNovels);
    }

    @Override
    public void getAllChaptersByNovelId(int novelId) {
        List<ChapterDto> latestNovels = mChapterResponsitory.getAllChaptersByNovelId(novelId);
//        Đổ các dữ liệu ra view xử lý
        mView.showChapters(latestNovels);

    }

    @Override
    public void getAllChaptersByNovelNew(int novelId) {
        List<ChapterDto> latestNovels = mChapterResponsitory.getAllChaptersByNovelNew(novelId);
//        Đổ các dữ liệu ra view xử lý
        mView.showChaptersNew(latestNovels);
    }

    @Override
    public void getTotalChapterCount(int novelId) {
        int totalChapterCount = mChapterResponsitory.countChaptersByNovelId(novelId);
        mView.showTotalChapterCount(totalChapterCount);
    }

}

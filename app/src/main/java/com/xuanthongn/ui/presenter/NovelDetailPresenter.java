package com.xuanthongn.ui.presenter;


import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.data.repository.NovelRepository;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.util.Constants;

import java.util.List;

public class NovelDetailPresenter implements INovelDetailConstract.IPresenter {
    private INovelDetailConstract.IView mView;
    private NovelRepository mNovelRepository;
    private CategoryRepository mCategoryRepository;
    private AppDatabase db;
    CategoryRepository categoryRepository;
    NovelRepository novelRepository;

    private Context context;
    public NovelDetailPresenter(Context context, NovelRepository novelRepository,CategoryRepository categoryRepository) {
        mNovelRepository = novelRepository;
        mCategoryRepository = categoryRepository;
    }

    public NovelDetailPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        this.context = context;
        categoryRepository = new CategoryRepository(db);
        novelRepository = new NovelRepository(db);
    }

    @Override
    public void setView(INovelDetailConstract.IView view) {
        mView = view;
    }

    @Override
    public void getLatestNovelsByCategory(int categoryId) {
        List<NovelDto> latestNovels = novelRepository.findLatestNovelsByCategory(categoryId);
        mView.showLatestNovels(latestNovels);
    }
    public int getCategoryIdByName(String categoryName) {
        return mCategoryRepository.getCategoryIdByName(categoryName);
    }
}

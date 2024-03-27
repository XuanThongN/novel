package com.xuanthongn.ui.presenter;


import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.util.Constants;

import java.util.List;

public class NovelDetailPresenter implements INovelDetailConstract.IPresenter {
private INovelDetailConstract.IView mView;
    private AppDatabase db;
    CategoryRepository categoryRepository;
    private Context context;

    public NovelDetailPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        this.context = context;
        categoryRepository = new CategoryRepository(db);
    }

    @Override
    public void setView(INovelDetailConstract.IView view) {
        mView = view;
    }

    @Override
    public void getCategory() {
        List<CategoryDto> categoryList = categoryRepository.findAll();

        if (mView != null) {
            mView.setCategory(categoryList);
        }
    }


}

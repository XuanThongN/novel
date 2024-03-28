package com.xuanthongn.ui.presenter;


import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
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
    }

    @Override
    public void setView(INovelDetailConstract.IView view) {
        mView = view;
    }

//    @Override
//    public void getCategory() {
//        List<CategoryDto> categoryList = categoryRepository.findAll();
//
//        if (mView != null) {
//            mView.setCategory(categoryList);
//        }
//    }

    @Override
    public void loadNovelDetails(int novelId) {
        if (novelRepository != null) {
            // Gọi phương thức findById của repository để lấy thông tin chi tiết của cuốn truyện dựa trên ID
            NovelDto novel = novelRepository.findById(novelId);
            if (novel != null) {
                // Hiển thị thông tin chi tiết của cuốn truyện
                mView.displayNovelDetails(novel);
            } else {
                // Hiển thị thông báo lỗi nếu không tìm thấy cuốn truyện
                mView.displayError("Không tìm thấy thông tin của cuốn truyện");
            }
        } else {
            // Xử lý trường hợp novelRepository là null
            mView.displayError("Không thể truy cập vào dữ liệu của cuốn truyện");
        }
    }



}

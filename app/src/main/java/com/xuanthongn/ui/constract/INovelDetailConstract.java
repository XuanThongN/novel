package com.xuanthongn.ui.constract;

import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;

import java.util.List;

public interface INovelDetailConstract {
    interface IView {
        void displayError(String errorMessage);
        void showLatestNovels(List<NovelDto> novels);

    }

    interface IPresenter {
        void setView(IView view);
        void getLatestNovelsByCategory(int categoryId);
    }
}

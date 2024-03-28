package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;

import java.util.List;

public interface INovelDetailConstract {
    interface IView {
//        void setCategory(List<CategoryDto> novelList);
        void displayNovelDetails(NovelDto novel);
        void displayError(String errorMessage);

    }

    interface IPresenter {
        void setView(IView view);
//        void getCategory();
        void loadNovelDetails(int novelId);
    }
}

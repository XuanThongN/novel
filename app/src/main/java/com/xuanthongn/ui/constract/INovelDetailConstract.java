package com.xuanthongn.ui.constract;

import com.xuanthongn.data.dto.CategoryDto;
import com.xuanthongn.data.model.Category;

import java.util.List;

public interface INovelDetailConstract {
    interface IView {
        void setCategory(List<CategoryDto> novelList);

    }

    interface IPresenter {
        void setView(IView view);
        void getCategory();
    }
}

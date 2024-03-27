package com.xuanthongn.ui.constract;

import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.dto.NovelDto;
import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.Product;

import java.util.List;

public interface ISearchConstract {
    interface IView {
        void showResults(List<NovelDto> novels);
    }

    interface IPresenter {
        void setView(IView view);
        void searchNovel(String search);


    }
}

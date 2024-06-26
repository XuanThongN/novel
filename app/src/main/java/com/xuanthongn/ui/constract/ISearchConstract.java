package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.novel.NovelDto;

import java.util.List;

public interface ISearchConstract {
    interface IView {
        void showResults(List<NovelDto> novels);

        void showError(String message);
    }

    interface IPresenter {
        void setView(IView view);
        void searchNovel(String search);


    }
}

package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.novel.NovelRecommendDto;

import java.util.List;

public interface IHomeConstract {
    interface IView {

        void setLoginInfo(String name);

        void setNovelRecommendToView(List<NovelRecommendDto> novelList);

        void setNovelNewestToView(List<NovelRecommendDto> novelNewest);


        void showError(String message);
    }

    interface IPresenter {
        void setView(IView view);

        void getLoginInfo();

        boolean getStoredLoginStatus();

        void getNovelRecommend();
        void getNovelNewest();
    }
}

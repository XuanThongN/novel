package com.xuanthongn.ui.constract;

import com.xuanthongn.data.dto.NovelDto;
import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.Product;
import com.xuanthongn.data.model.novel.NovelRecommendDto;

import java.util.List;

public interface IHomeConstract {
    interface IView {

        void setLoginInfo(String name);

        void setNovelRecommendToView(List<NovelRecommendDto> novelList);


    }

    interface IPresenter {
        void setView(IView view);

        void getLoginInfo();

        boolean getStoredLoginStatus();

        void getNovelRecommend();

    }
}

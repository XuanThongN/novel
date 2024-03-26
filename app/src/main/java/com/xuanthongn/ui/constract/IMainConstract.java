package com.xuanthongn.ui.constract;

import android.content.Context;

import com.xuanthongn.data.entity.Product;

import java.util.List;

public interface IMainConstract {
    interface IView {

//        void setLoginInfo(String email);
//
//        void setHotProductsToView(List<Product> productList);

    }

    interface IPresenter {
        void setView(IView view);

//        void getHotProducts();
//
//        void getLoginInfo();
//
        boolean getStoredLoginStatus();

    }
}

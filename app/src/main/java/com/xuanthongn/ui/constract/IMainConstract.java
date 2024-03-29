package com.xuanthongn.ui.constract;

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

package com.xuanthongn.ui.constract;

public interface IAccountConstract {
    interface IView {
        void setAccountLayout(boolean isLogin);

//        void setLoginInfo(String email);
//
//        void setHotProductsToView(List<Product> productList);

    }

    interface IPresenter {
        void setView(IView view);

        boolean getStoredLoginStatus();
        void logout();

    }
}

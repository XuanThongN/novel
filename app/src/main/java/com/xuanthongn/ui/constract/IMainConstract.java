package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.Product;

import java.util.List;

public interface IMainConstract {
    interface IView{
        void setHotProductsToView(List<Product> productList);
    }
    interface IPresenter{
        void setView(IView view);
        void getHotProducts();
    }
}

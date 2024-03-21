package com.xuanthongn.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.ProductDao;
import com.xuanthongn.data.entity.Product;
import com.xuanthongn.ui.constract.IMainConstract;
import com.xuanthongn.util.Constants;

import java.util.List;

public class MainPresenter implements IMainConstract.IPresenter {
    private IMainConstract.IView mView;
    private AppDatabase db;

    public MainPresenter(Context context){
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).build();
    }

    @Override
    public void setView(IMainConstract.IView view) {
        mView = view;
    }

    @Override
    public void getHotProducts() {
        ProductDao productDao = db.productDao();
        List<Product> productList = productDao.getHotProducts();

        mView.setHotProductsToView(productList);
    }
}

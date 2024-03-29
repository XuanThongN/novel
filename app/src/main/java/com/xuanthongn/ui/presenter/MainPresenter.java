package com.xuanthongn.ui.presenter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.ui.constract.IMainConstract;
import com.xuanthongn.util.Constants;

public class MainPresenter implements IMainConstract.IPresenter {
    private IMainConstract.IView mView;
    private AppDatabase db;

    private Context context;

    public MainPresenter(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).build();
    }

    @Override
    public void setView(IMainConstract.IView view) {
        mView = view;
    }

//    @Override
//    public void getHotProducts() {
//        ProductDao productDao = db.productDao();
//        List<Product> productList = productDao.getHotProducts();
//
//        mView.setHotProductsToView(productList);
//    }
//
//    @Override
//    public void getLoginInfo() {
//        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
//        String email = sharedPreferences.getString(Constants.KEY_EMAIL, null);
//        mView.setLoginInfo(email);
//    }
//
    @Override
    public boolean getStoredLoginStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getBoolean(Constants.KEY_LOGIN_STATUS, false);

    }

}

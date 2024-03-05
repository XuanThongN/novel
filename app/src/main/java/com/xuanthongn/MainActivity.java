package com.xuanthongn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.data.model.Product;
import com.xuanthongn.ui.constract.IMainConstract;
import com.xuanthongn.ui.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends BaseActivity implements IMainConstract.IView {
    private RecyclerView mRvHotProduct;
    private IMainConstract.IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
        mPresenter.setView(this);

        initGUI();
    }

    private void initGUI() {
        mRvHotProduct = findViewById(R.id.rv_hot_product);
    }

    @Override
    public void setHotProductsToView(List<Product> productList) {

    }
}
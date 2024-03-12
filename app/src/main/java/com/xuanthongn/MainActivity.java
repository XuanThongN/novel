package com.xuanthongn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.data.model.Product;
import com.xuanthongn.ui.constract.IMainConstract;
import com.xuanthongn.ui.presenter.MainPresenter;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        // Java
        ImageCarousel carousel = findViewById(R.id.carousel);

        // Register lifecycle. For activity this will be lifecycle/getLifecycle() and for fragments it will be viewLifecycleOwner/getViewLifecycleOwner().
        carousel.registerLifecycle(getLifecycle());

        List<CarouselItem> list = new ArrayList<>();

        // Image URL with caption
        list.add(new CarouselItem("https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Cre: Thong"));

// Just image URL
        list.add(new CarouselItem("https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));

// Image URL with header
        Map<String, String> headers = new HashMap<>();
        headers.put("header_key", "header_value");

        list.add(new CarouselItem("https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080", headers)
        );

// Just image drawable
        list.add(new CarouselItem(R.drawable.test));


        carousel.setData(list);
    }

    private void initGUI() {

//        mRvHotProduct = findViewById(R.id.rv_hot_product);
    }

    @Override
    public void setHotProductsToView(List<Product> productList) {

    }


}
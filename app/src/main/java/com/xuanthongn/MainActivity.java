package com.xuanthongn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;

import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.data.model.CategoryItem;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.Product;
import com.xuanthongn.ui.adapter.CategoryItemAdapter;
import com.xuanthongn.ui.adapter.NovelContinueReadingAdapter;
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
    private List<CategoryItem> categories;
    private GridView categoryGrid;

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
        list.add(new CarouselItem("https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Cre: Thong"));

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


        //Show list categories
        categoryGrid = findViewById(R.id.category_grid);

        // Prepare category data
        categories = new ArrayList<>();
        categories.add(new CategoryItem(R.drawable.ic_account_balance_32, "Bảng xếp hang"));
        categories.add(new CategoryItem(R.drawable.ic_bloodtype_32, "Nhóm máu"));
        categories.add(new CategoryItem(R.drawable.ic_account_balance_32, "Phúc lợi"));
        categories.add(new CategoryItem(R.drawable.ic_bloodtype_32, "Cộng đồng"));
        categories.add(new CategoryItem(R.drawable.ic_account_balance_32, "Truyện chọn lọc hay nhất"));
        categories.add(new CategoryItem(R.drawable.ic_bloodtype_32, "Nhóm máu"));
        categories.add(new CategoryItem(R.drawable.ic_account_balance_32, "Truyện dịch"));
        categories.add(new CategoryItem(R.drawable.ic_bloodtype_32, "Truyện ngắn"));
        // ... add more categories

        // Create and set adapter for GridView
        CategoryItemAdapter adapter = new CategoryItemAdapter(this, categories);
        categoryGrid.setAdapter(adapter);



        //View continue reading
        RecyclerView rvContinueReading = findViewById(R.id.rv_continue_reading);
        List<Novel> novels = new ArrayList<>();
        novels.add(new Novel(1, "Truyện 1", "Tác giả 1", "Mô tả 1", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"));
        novels.add(new Novel(2, "Truyện 2", "Tác giả 2", "Mô tả 2", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));
        novels.add(new Novel(3, "Truyện 3", "Tác giả 3", "Mô tả 3", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"));
        novels.add(new Novel(4, "Truyện 4", "Tác giả 4", "Mô tả 4", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));
        novels.add(new Novel(5, "Truyện 5", "Tác giả 5", "Mô tả 5", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"));
        novels.add(new Novel(6, "Truyện 6", "Tác giả 6", "Mô tả 6", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));

        rvContinueReading.setAdapter(new NovelContinueReadingAdapter(this, novels));
    }

    private void initGUI() {

//        mRvHotProduct = findViewById(R.id.rv_hot_product);
    }

    @Override
    public void setHotProductsToView(List<Product> productList) {

    }


}
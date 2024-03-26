package com.xuanthongn.ui.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.entity.Product;
import com.xuanthongn.data.model.CategoryItem;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.NovelRecommend;
import com.xuanthongn.ui.adapter.CategoryItemAdapter;
import com.xuanthongn.ui.adapter.NovelContinueReadingAdapter;
import com.xuanthongn.ui.adapter.NovelRecommendAdapter;
import com.xuanthongn.ui.constract.IHomeConstract;
import com.xuanthongn.ui.main.LoginActivity;
import com.xuanthongn.ui.main.NovelPageSearchActivity;
import com.xuanthongn.ui.presenter.HomePresenter;
import com.xuanthongn.ui.main.RecommendActivity;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.annotations.NonNull;

public class HomeFragment extends Fragment implements IHomeConstract.IView {
    private IHomeConstract.IPresenter mPresenter;
    private GridView categoryGrid;
    private List<CategoryItem> categories;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initGUI(view);
        // Xử lý sự kiện click của buttonLogin
        Button buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang LoginActivity
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        ImageView imageSearchView = view.findViewById(R.id.search_icon);
        imageSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang LoginActivity
                Intent intent = new Intent(getActivity(), NovelPageSearchActivity.class);
                startActivity(intent);
            }
        });

        TextView seeMoreNovelView = view.findViewById(R.id.novel_seeMore_Home_Tview);
        seeMoreNovelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang LoginActivity
                Intent intent = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new HomePresenter(getContext());
        mPresenter.setView(this);
        mPresenter.getLoginInfo();

    }


    private void initGUI(View view) {
        Context context = this.getContext();
        // Java
        ImageCarousel carousel = view.findViewById(R.id.carousel);

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


//        Show list categories
        categoryGrid = view.findViewById(R.id.category_grid);

        // Prepare category data
        categories = new ArrayList<>();
        categories.add(new CategoryItem(R.drawable.rank_icon, "Bảng xếp hang"));
        categories.add(new CategoryItem(R.drawable.chat_icon, "Chat chit"));
        categories.add(new CategoryItem(R.drawable.gold_icon, "Phúc lợi"));
        categories.add(new CategoryItem(R.drawable.community_icon, "Cộng đồng"));
        categories.add(new CategoryItem(R.drawable.translate_icon, "Truyện dịch"));
        categories.add(new CategoryItem(R.drawable.ic_stars_32, "Truyện chọn lọc"));
        categories.add(new CategoryItem(R.drawable.feather_icon, "Truyện ngắn"));
        categories.add(new CategoryItem(R.drawable.teammate_icon, "Nhóm dịch"));
        // ... add more categories

        // Create and set adapter for GridView
        CategoryItemAdapter adapter = new CategoryItemAdapter(context, categories);
        categoryGrid.setAdapter(adapter);


//        View continue reading
        RecyclerView rvContinueReading = view.findViewById(R.id.rv_continue_reading);
        List<Novel> novels = new ArrayList<>();
        novels.add(new Novel(1, "Truyện 1", "Tác giả 1", "Mô tả 1", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"));
        novels.add(new Novel(2, "Truyện 2", "Tác giả 2", "Mô tả 2", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));
        novels.add(new Novel(3, "Truyện 3", "Tác giả 3", "Mô tả 3", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"));
        novels.add(new Novel(4, "Truyện 4", "Tác giả 4", "Mô tả 4", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));
        novels.add(new Novel(5, "Truyện 5", "Tác giả 5", "Mô tả 5", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"));
        novels.add(new Novel(6, "Truyện 6", "Tác giả 6", "Mô tả 6", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));

        rvContinueReading.setAdapter(new NovelContinueReadingAdapter(context, novels));


        //View novel recommend
        RecyclerView rvNovelRecommend = view.findViewById(R.id.rv_novel_recommend);
        List<NovelRecommend> novelList = new ArrayList<>();
        novelList.add(new NovelRecommend(1, "Truyện về than thoai hy lap", "Tác giả 1", "Mô tả 1", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Thể loại 1"));
        novelList.add(new NovelRecommend(2, "Truyện 2", "Tác giả 2", "Mô tả 2", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080", "Thể loại 2"));
        novelList.add(new NovelRecommend(3, "Truyện 3", "Tác giả 3", "Mô tả 3", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Thể loại 3"));
        novelList.add(new NovelRecommend(4, "Truyện 4", "Tác giả 4", "Mô tả 4", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080", "Thể loại 4"));
        novelList.add(new NovelRecommend(5, "Truyện 5", "Tác giả 5", "Mô tả 5", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Thể loại 5"));
        novelList.add(new NovelRecommend(6, "Truyện 6", "Tác giả 6", "Mô tả 6", "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080", "Thể loại 6"));

        rvNovelRecommend.setAdapter(new NovelRecommendAdapter(context, novelList));

    }

    @Override
    public void setLoginInfo(String name) {
        boolean isLogin = mPresenter.getStoredLoginStatus();
        LinearLayout layoutUserInfo = this.getView().findViewById(R.id.layout_user_info);
        LinearLayout layoutLogin = this.getView().findViewById(R.id.layout_login_button);
        TextView tvEmail = this.getView().findViewById(R.id.tv_email);
        if (isLogin) {
            layoutUserInfo.setVisibility(View.VISIBLE);
            layoutLogin.setVisibility(View.GONE);
            tvEmail.setText(name);
        } else {
            layoutLogin.setVisibility(View.VISIBLE);
            layoutUserInfo.setVisibility(View.GONE);
        }

    }

    @Override
    public void setHotProductsToView(List<Product> productList) {

    }
}

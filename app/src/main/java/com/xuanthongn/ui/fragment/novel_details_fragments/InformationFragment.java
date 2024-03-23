package com.xuanthongn.ui.fragment.novel_details_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.Category;
import com.xuanthongn.data.model.CategoryItem;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.NovelRecommend;
import com.xuanthongn.ui.adapter.CategoryItemAdapter;
import com.xuanthongn.ui.adapter.CategoryNovelItemAdapter;
import com.xuanthongn.ui.adapter.NovelContinueReadingAdapter;
import com.xuanthongn.ui.adapter.NovelRecommendAdapter;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        initGUI(view);
        // Inflate the layout for this fragment
        return view;
    }
    private void initGUI(View view) {
        Context context = this.getContext();

//        View continue reading
        RecyclerView rvContinueReading = view.findViewById(R.id.rv_continue_category_novel);
        List<Category> category = new ArrayList<>();
        category.add(new Category(1, "Truyền Thuyết"));
        category.add(new Category(2, "Tiểu Thuyết"));
        category.add(new Category(3, "Tiểu Thuyết"));
        category.add(new Category(4, "Tiểu Thuyết"));
        category.add(new Category(5, "Tiểu Thuyết"));

        rvContinueReading.setAdapter(new CategoryNovelItemAdapter(context, category));
    }

}

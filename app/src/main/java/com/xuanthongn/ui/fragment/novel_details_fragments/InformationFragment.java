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
import com.xuanthongn.data.model.NovelComment;
import com.xuanthongn.data.model.NovelRecommend;
import com.xuanthongn.data.model.NovelYourLikes;
import com.xuanthongn.ui.adapter.CategoryItemAdapter;
import com.xuanthongn.ui.adapter.CategoryNovelItemAdapter;
import com.xuanthongn.ui.adapter.NovelContinueReadingAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsCommentAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsYourlikeAdapter;
import com.xuanthongn.ui.adapter.NovelRecommendAdapter;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.Date;
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

//        Truyền dữ liệu vào thể loại truyện
        RecyclerView rvContinueReading = view.findViewById(R.id.rv_continue_category_novel);
        List<Category> category = new ArrayList<>();
        category.add(new Category(1, "Truyền Thuyết"));
        category.add(new Category(2, "Tiểu Thuyết"));
        category.add(new Category(3, "Tiểu Thuyết"));
        category.add(new Category(4, "Tiểu Thuyết"));
        category.add(new Category(5, "Tiểu Thuyết"));

        rvContinueReading.setAdapter(new CategoryNovelItemAdapter(context, category));

//        Truyền dữ liệu vào  bình luận
        RecyclerView rvContinueComment= view.findViewById(R.id.rv_continue_comment_novel);
        List<NovelComment> novelComment = new ArrayList<>();
        novelComment.add(new NovelComment(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "helo", 145, new Date(102, 1, 12), 3, 4));
        novelComment.add(new NovelComment(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "helo", 145, new Date(102, 1, 12), 3, 4));
        novelComment.add(new NovelComment(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "helo", 145, new Date(102, 1, 12), 3, 4));
        novelComment.add(new NovelComment(4, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "helo", 145, new Date(102, 1, 12), 3, 4));

        rvContinueComment.setAdapter(new NovelDetailsCommentAdapter(context, novelComment));


        //        Truyền dữ liệu vào mục truyện bạn có thể thích
        RecyclerView rvContinueYourlike= view.findViewById(R.id.rv_continue_yourlike_novel);
        List<NovelYourLikes> novelYourlike = new ArrayList<>();
        novelYourlike.add(new NovelYourLikes(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hoài Ngọc truyền kỳ", "Ngày xửa ngày xưa ở một ngôi nhà nọ"));
        novelYourlike.add(new NovelYourLikes(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hoài Ngọc truyền kỳ", "Ngày xửa ngày xưa ở một ngôi nhà nọ"));
        novelYourlike.add(new NovelYourLikes(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hoài Ngọc truyền kỳ", "Ngày xửa ngày xưa ở một ngôi nhà nọ"));
        novelYourlike.add(new NovelYourLikes(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Hoài Ngọc truyền kỳ", "Ngày xửa ngày xưa ở một ngôi nhà nọ"));

        rvContinueYourlike.setAdapter(new NovelDetailsYourlikeAdapter(context, novelYourlike));

    }

}

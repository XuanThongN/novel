package com.xuanthongn.ui.fragment.novel_page_search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.Category;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.ui.adapter.NovelSearchCategogyAdapter;
import com.xuanthongn.ui.adapter.NovelSearchResultAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComicSearchFragment extends Fragment {
    RecyclerView recyclerView;
    List<NovelRecommendDto> novels;
    public ComicSearchFragment(List<NovelDto> data){
        setData(data);
    };

    public void setData(List<NovelDto> data){
        if(data != null){
            novels = data.stream().map( x -> {
                NovelRecommendDto novel =  new NovelRecommendDto();
                novel.setId(x.getId());
                novel.setName(x.getName());
                novel.setImageUrl(x.getImageUrl());
                novel.setCategoryName(x.getCategoryName());
                return  novel;
            }).collect(Collectors.toList());
        }else {
            novels = new ArrayList<NovelRecommendDto>();
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_novel_comic_search, container, false);

        initGUI(view);
        // Inflate the layout for this fragment
        return view;
    }

    private void initGUI(View view) {
        Context context = this.getContext();

//        Truyền dữ liệu vào list truyện
        RecyclerView rv_novel_comic_category = view.findViewById(R.id.rv_novel_comic_category);
        List<Category> category = new ArrayList<>();
        category.add(new Category(1, "Truyền Thuyết"));
        category.add(new Category(2, "Truyền Thuyết"));
        category.add(new Category(3, "Truyền Thuyết"));
        category.add(new Category(4, "Truyền Thuyết"));

        rv_novel_comic_category.setAdapter(new NovelSearchCategogyAdapter(context, category));


        //        Truyền dữ liệu vào list truyện
        RecyclerView rv_novel_comic_result_category = view.findViewById(R.id.rv_novel_comic_result_category);

//        List<NovelRecommendDto> resultNovel = new ArrayList<>();
//        resultNovel.add(new NovelRecommendDto(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));
//        resultNovel.add(new NovelRecommendDto(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));
//        resultNovel.add(new NovelRecommendDto(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));
//        resultNovel.add(new NovelRecommendDto(4, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));
//        resultNovel.add(new NovelRecommendDto(5, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));
//        resultNovel.add(new NovelRecommendDto(6, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));        resultNovel.add(new NovelRecommendDto(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));
//        resultNovel.add(new NovelRecommendDto(7, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));
//        resultNovel.add(new NovelRecommendDto(8, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080","Ngày đại hôn bị nữ chính giết"));


        rv_novel_comic_result_category.setLayoutManager(new GridLayoutManager(context, 3));

        rv_novel_comic_result_category.setAdapter(new NovelSearchResultAdapter(context, novels));
    }


}
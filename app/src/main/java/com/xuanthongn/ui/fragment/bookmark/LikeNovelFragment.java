package com.xuanthongn.ui.fragment.bookmark;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.BookMark;
import com.xuanthongn.ui.adapter.BookMarkAdapter;

import java.util.ArrayList;
import java.util.List;

public class LikeNovelFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookMarkAdapter adapter;
    private List<BookMark> bookMarkList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_novel_read, container, false);


        initGUI(view);
        // Inflate the layout for this fragment
        return view;
    }


    private void initGUI(@NonNull View view) {
        Context context = this.getContext();
        RecyclerView rvNovelRecommend = view.findViewById(R.id.rv_novel_bookmark);
        // Tạo dữ liệu giả lập cho sách
        List<BookMark> novelList = new ArrayList<>();

        novelList.add(new BookMark(R.drawable.bia, "T.Truyện Tranh", "Toàn cầu băng phong: Ta chế tạo phòng an toàn tại tận thế", "Chapter 1/159", R.drawable.ic_delete_24));
        novelList.add(new BookMark(R.drawable.bia, "T.Truyện Tranh", "Toàn cầu băng phong: Ta chế tạo phòng an toàn tại tận thế", "Chapter 1/159", R.drawable.ic_delete_24));
        novelList.add(new BookMark(R.drawable.bia, "T.Truyện Tranh", "Toàn cầu băng phong: Ta chế tạo phòng an toàn tại tận thế", "Chapter 1/159", R.drawable.ic_delete_24));

        // Khởi tạo và thiết lập adapter cho RecyclerView
        rvNovelRecommend.setAdapter(new BookMarkAdapter(context, novelList));
    }

}

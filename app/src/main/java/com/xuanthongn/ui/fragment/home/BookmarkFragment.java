package com.xuanthongn.ui.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.xuanthongn.R;
import com.xuanthongn.data.model.BookMark;
import com.xuanthongn.ui.adapter.BookMarkAdapter;
import com.xuanthongn.ui.adapter.BookMarkPagerAdapter;
import com.xuanthongn.ui.adapter.CategoryItemAdapter;
import com.xuanthongn.ui.fragment.bookmark.DownLoadNovelFragment;
import com.xuanthongn.ui.fragment.bookmark.LikeNovelFragment;
import com.xuanthongn.ui.fragment.bookmark.ReadNovelFragment;

import java.util.ArrayList;
import java.util.List;

public class BookmarkFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    private RecyclerView recyclerViewBookmark;
    private List<BookMark> bookList;
    private BookMarkAdapter bookMarkAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);
        Spinner spinner = view.findViewById(R.id.spinner_filter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout_bookmark);
        ViewPager2 viewPager = view.findViewById(R.id.view_pager_bookmark);
        String[] options = {"Tất cả", "Tiểu thuyết", "Truyện tranh", "Truyện audio", "Truyện ngắn"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, options);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gán ArrayAdapter cho Spinner
        spinner.setAdapter(spinnerAdapter);
        // Khởi tạo và cài đặt adapter cho ViewPager
        BookMarkPagerAdapter adapter = new BookMarkPagerAdapter(requireActivity());
        viewPager.setAdapter(adapter);

        // Kết hợp TabLayout với ViewPager
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(getTabTitle(position))
        ).attach();

        return view;
    }


    // Phương thức này trả về tiêu đề của mỗi tab
    private String getTabTitle(int position) {
        switch (position) {
            case 0:
                return "Đang đọc";
            case 1:
                return "Đã thích";
            case 2:
                return "Đã tải";
            default:
                return "";
        }
    }


}




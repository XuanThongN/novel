package com.xuanthongn.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.xuanthongn.data.dto.NovelDto;
import com.xuanthongn.ui.fragment.home.AccountFragment;
import com.xuanthongn.ui.fragment.home.BookmarkFragment;
import com.xuanthongn.ui.fragment.home.HomeFragment;
import com.xuanthongn.ui.fragment.novel_page_search.ComicSearchFragment;
import com.xuanthongn.ui.fragment.novel_page_search.NovelAudioSearchFragment;
import com.xuanthongn.ui.fragment.novel_page_search.NovelSearchFragment;

import java.util.ArrayList;
import java.util.List;


public class NovelSearchAdapter extends FragmentStateAdapter {

    List<NovelDto> novels;
    public NovelSearchAdapter(@NonNull FragmentActivity fragmentActivity, List<NovelDto> data) {
        super(fragmentActivity);
        novels = data;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ComicSearchFragment(novels);
            case 1:
                return new NovelSearchFragment();
            case 2:
                return new NovelAudioSearchFragment();
            default:
                return new ComicSearchFragment(novels);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

package com.xuanthongn.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.xuanthongn.ui.fragment.home.AccountFragment;
import com.xuanthongn.ui.fragment.home.BookmarkFragment;
import com.xuanthongn.ui.fragment.home.HomeFragment;
import com.xuanthongn.ui.fragment.novel_page_search.ComicSearchFragment;
import com.xuanthongn.ui.fragment.novel_page_search.NovelAudioSearchFragment;
import com.xuanthongn.ui.fragment.novel_page_search.NovelSearchFragment;


public class NovelSearchAdapter extends FragmentStateAdapter {
    public NovelSearchAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ComicSearchFragment();
            case 1:
                return new NovelSearchFragment();
            case 2:
                return new NovelAudioSearchFragment();
            default:
                return new ComicSearchFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

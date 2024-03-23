package com.xuanthongn.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.xuanthongn.ui.fragment.bookmark.DownLoadNovelFragment;
import com.xuanthongn.ui.fragment.bookmark.LikeNovelFragment;
import com.xuanthongn.ui.fragment.bookmark.ReadNovelFragment;
import com.xuanthongn.ui.fragment.novel_details_fragments.ChapterFragment;
import com.xuanthongn.ui.fragment.novel_details_fragments.InformationFragment;


public class BookMarkPagerAdapter extends FragmentStateAdapter {
    private static final int NUM_TABS = 3; // Số lượng tab

    public BookMarkPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Trả về fragment tương ứng với mỗi vị trí
        switch (position) {
            case 0:
                return new ReadNovelFragment();
            case 1:
                return new LikeNovelFragment();
            case 2:
                return new DownLoadNovelFragment();
            default:
                return new ReadNovelFragment();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS; // Trả về số lượng tab
    }
}


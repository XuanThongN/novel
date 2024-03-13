package com.xuanthongn.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.xuanthongn.base.novel_details_fragments.ChapterFragment;
import com.xuanthongn.base.novel_details_fragments.InformationFragment;


public class NovelDetailsPagerAdapter extends FragmentStateAdapter {
    public NovelDetailsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ChapterFragment();
            case 1:
                return new InformationFragment();
            default:
                return new ChapterFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

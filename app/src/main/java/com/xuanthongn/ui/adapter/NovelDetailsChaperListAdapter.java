package com.xuanthongn.ui.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.xuanthongn.R;
import com.xuanthongn.data.dao.ChapterDao;
import com.xuanthongn.data.model.Chapter;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.chapter.ChapterDto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NovelDetailsChaperListAdapter extends RecyclerView.Adapter<NovelDetailsChaperListAdapter.NovelChapterListViewHolder> {

    private Context context;

    private List<ChapterDto> chapter;


    public NovelDetailsChaperListAdapter(Context context, List<ChapterDto> chapter) {
        this.context = context;
        this.chapter = chapter;
    }

    @Override
    public NovelChapterListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_detail_chapter_list_item, parent, false);
        return new NovelChapterListViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(NovelChapterListViewHolder holder, int position) {
        ChapterDto novel = chapter.get(position);
        holder.chapterNameView.setText("Chương " + novel.getChapterId()+ ":  " + novel.getName());

    }

    @Override
    public int getItemCount() {
        return chapter.size();
    }

    public static class NovelChapterListViewHolder extends RecyclerView.ViewHolder {

        TextView chapterNameView;
        TextView chapterDateView;

        public NovelChapterListViewHolder(View itemView) {
            super(itemView);
            chapterNameView = itemView.findViewById(R.id.novel_detail_chapters_list);
        }
    }
}

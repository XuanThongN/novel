package com.xuanthongn.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.xuanthongn.R;
import com.xuanthongn.data.model.Chapter;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;

import java.util.List;


public class NovelReadingChapterAdapter extends RecyclerView.Adapter<NovelReadingChapterAdapter.NovelViewHolder> {

    private Context mContext;
    private List<ChapterDto> mChapters;

    public NovelReadingChapterAdapter(Context context, List<ChapterDto> chapters) {
        this.mContext = context;
        this.mChapters = chapters;
    }

    @Override
    public NovelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.novel_reading_item, parent, false);
        return new NovelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NovelViewHolder holder, int position) {
        ChapterDto novel = mChapters.get(position);
        holder.nameChapter.setText("Chương " + novel.getChapterId() + ":  " + novel.getName());
        holder.contentChapter.setText(novel.getContent());
    }

    @Override
    public int getItemCount() {
        return mChapters.size();
    }

    public static class NovelViewHolder extends RecyclerView.ViewHolder {

        TextView nameChapter;
        TextView contentChapter;

        public NovelViewHolder(View itemView) {
            super(itemView);
            nameChapter = itemView.findViewById(R.id.novel_content);
            contentChapter = itemView.findViewById(R.id.novel_content_edit);
        }
    }
}
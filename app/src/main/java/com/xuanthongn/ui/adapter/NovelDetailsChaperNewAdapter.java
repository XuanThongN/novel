package com.xuanthongn.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.Chapter;
import com.xuanthongn.data.model.chapter.ChapterDto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NovelDetailsChaperNewAdapter extends RecyclerView.Adapter<NovelDetailsChaperNewAdapter.NovelChapterNewViewHolder> {

    private Context context;
    private List<ChapterDto> chapter;

    public NovelDetailsChaperNewAdapter(Context context, List<ChapterDto> chapter) {
        this.context = context;
        this.chapter = chapter;
    }


    @Override
    public NovelDetailsChaperNewAdapter.NovelChapterNewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_detail_chapter_new_item, parent, false);
        return new NovelDetailsChaperNewAdapter.NovelChapterNewViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NovelDetailsChaperNewAdapter.NovelChapterNewViewHolder holder, int position) {
        ChapterDto novel = chapter.get(position);
        // Gán giá trị vào TextView
        holder.chapterNameView.setText(novel.getName());
    }

    @Override
    public int getItemCount() {
        return chapter.size();
    }

    public class NovelChapterNewViewHolder extends RecyclerView.ViewHolder {

        TextView chapterNameView;

        public NovelChapterNewViewHolder(View itemView) {
            super(itemView);
            chapterNameView = itemView.findViewById(R.id.novel_detail_chapters_new);
        }
    }

    public void setRecyclerViewLayoutManager(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }
}

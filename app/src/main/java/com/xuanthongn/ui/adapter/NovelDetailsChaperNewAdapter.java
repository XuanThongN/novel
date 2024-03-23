package com.xuanthongn.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.Chapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NovelDetailsChaperNewAdapter extends RecyclerView.Adapter<NovelDetailsChaperNewAdapter.NovelChapterNewViewHolder> {

    private Context context;
    private List<Chapter> chapter;

    public NovelDetailsChaperNewAdapter(Context context, List<Chapter> chapter) {
        this.context = context;
        this.chapter = chapter;
    }

    @Override
    public NovelChapterNewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_detail_chapter_new_item, parent, false);
        return new NovelChapterNewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NovelChapterNewViewHolder holder, int position) {
        Chapter novel = chapter.get(position);
        holder.chapterNameView.setText("Chương " + String.valueOf(novel.getId()) + ": " + novel.getName());

    }

    @Override
    public int getItemCount() {
        return chapter.size();
    }

    public static class NovelChapterNewViewHolder extends RecyclerView.ViewHolder {

        TextView chapterNameView;
        TextView chapterDateView;

        public NovelChapterNewViewHolder(View itemView) {
            super(itemView);
            chapterNameView = itemView.findViewById(R.id.novel_detail_chapters_new);
        }
    }

    public void setRecyclerViewLayoutManager(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }
}

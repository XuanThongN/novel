package com.xuanthongn.ui.adapter;

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
import com.xuanthongn.data.model.Novel;

import java.util.List;


public class NovelContinueReadingAdapter extends RecyclerView.Adapter<NovelContinueReadingAdapter.NovelViewHolder> {

    private Context context;
    private List<Novel> novels;

    public NovelContinueReadingAdapter(Context context, List<Novel> novels) {
        this.context = context;
        this.novels = novels;
    }

    @Override
    public NovelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_item, parent, false);
        return new NovelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NovelViewHolder holder, int position) {
        Novel novel = novels.get(position);
        holder.nameView.setText(novel.getName());
        holder.chapterNumberView.setText("Chương " + novel.getId());

        //Set background image for layout

        Glide.with(holder.image.getContext())
                .load(novel.getImageUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                        holder.image.setBackground(resource);
                        return true;
                    }

                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }
                })
                .preload();
    }

    @Override
    public int getItemCount() {
        return novels.size();
    }

    public static class NovelViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nameView;
        TextView chapterNumberView;

        public NovelViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.novel_image);
            chapterNumberView = itemView.findViewById(R.id.chapter_number);
            nameView = itemView.findViewById(R.id.novel_name);
        }
    }
}

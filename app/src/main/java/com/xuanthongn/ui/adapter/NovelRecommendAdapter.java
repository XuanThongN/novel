package com.xuanthongn.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.xuanthongn.R;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.NovelRecommend;

import java.util.List;


public class NovelRecommendAdapter extends RecyclerView.Adapter<NovelRecommendAdapter.NovelRecommendViewHolder> {

    private final Context context;
    private final List<NovelRecommend> novels;

    public NovelRecommendAdapter(Context context, List<NovelRecommend> novels) {
        this.context = context;
        this.novels = novels;
    }

    @NonNull
    @Override
    public NovelRecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_recommed_item, parent, false);
        return new NovelRecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NovelRecommendViewHolder holder, int position) {
        NovelRecommend novel = novels.get(position);
        holder.nameView.setText(novel.getName());
        holder.categoryNameView.setText(novel.getCategoryName());

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

    public static class NovelRecommendViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nameView;
        TextView categoryNameView;

        public NovelRecommendViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.novel_recommend_image);
            nameView = itemView.findViewById(R.id.novel_recommend_name);
            categoryNameView = itemView.findViewById(R.id.category_novel_recommend_name);
        }
    }
}

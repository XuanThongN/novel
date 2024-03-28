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
import com.xuanthongn.data.model.novel.NovelDto;

import java.util.List;

public class NovelDetailsYourlikeAdapter extends RecyclerView.Adapter<NovelDetailsYourlikeAdapter.NovelDetailViewHolder> {

    private Context context;
    private List<NovelDto> novelscomments;

    public NovelDetailsYourlikeAdapter(Context context, List<NovelDto> novelscomments) {
        this.context = context;
        this.novelscomments = novelscomments;
    }

    @NonNull
    @Override
    public NovelDetailsYourlikeAdapter.NovelDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_like_item, parent, false);
        return new NovelDetailsYourlikeAdapter.NovelDetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NovelDetailsYourlikeAdapter.NovelDetailViewHolder holder, int position) {
        NovelDto novelYourLikes = novelscomments.get(position);
        holder.nameView.setText(novelYourLikes.getName());
        holder.contentView.setText(novelYourLikes.getDescription());
        //Set background image for layout

        Glide.with(holder.image.getContext())
                .load(novelYourLikes .getImageUrl())
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
        return novelscomments.size();
    }

    public static class NovelDetailViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nameView;
        TextView contentView;


        public NovelDetailViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.novel_yourlike_img);
            nameView = itemView.findViewById(R.id.novel_yourlike_content);
            contentView = itemView.findViewById(R.id.novel_yourlike_category);

        }
    }
}

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
import com.xuanthongn.data.model.novel.NovelRecommendDto;

import java.util.List;


public class NovelRecommendBtvAdapter extends RecyclerView.Adapter<NovelRecommendBtvAdapter.NovelRecommendViewHolder> {

    private final Context context;
    private final List<NovelRecommendDto> novels;

    public NovelRecommendBtvAdapter(Context context, List<NovelRecommendDto> novels) {
        this.context = context;
        this.novels = novels;
    }

    @NonNull
    @Override
    public NovelRecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_recommed_btv, parent, false);
        return new NovelRecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NovelRecommendViewHolder holder, int position) {
        NovelRecommendDto novel = novels.get(position);
        holder.nameView.setText(novel.getName());

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
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open NovelDetailsActivity when item is clicked
//                Intent intent = new Intent(context, NovelDetailsActivity.class);
//                // Pass data if needed
//                intent.putExtra("novel_id", novel.getId());
//                context.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return novels.size();
    }

    public static class NovelRecommendViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nameView;

        public NovelRecommendViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.novel_recommend_btv_image);
            nameView = itemView.findViewById(R.id.novel_recommend_btv_name);
        }
    }
}

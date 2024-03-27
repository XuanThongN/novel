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
import com.xuanthongn.data.model.novel.NovelRecommendDto;

import java.util.List;

public class NovelSearchResultAdapter extends RecyclerView.Adapter<NovelSearchResultAdapter.ViewNovelSearchResltHolder> {
    private Context context;
    private List<NovelRecommendDto> categories;

    public NovelSearchResultAdapter(Context context, List<NovelRecommendDto> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public NovelSearchResultAdapter.ViewNovelSearchResltHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_result_search_item, parent, false);
        return new NovelSearchResultAdapter.ViewNovelSearchResltHolder(view);
    }

    @Override
    public void onBindViewHolder(NovelSearchResultAdapter.ViewNovelSearchResltHolder holder, int position) {
        NovelRecommendDto novel = categories.get(position);
        holder.nameView.setText(novel.getName());
        holder.chapterView.setText( String.valueOf(novel.getId()+" Chương " ));

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
        return categories.size();
    }

    public class ViewNovelSearchResltHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView nameView;
        TextView chapterView;

        public ViewNovelSearchResltHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.novel_result_search_image);
            nameView = itemView.findViewById(R.id.novel_result_search_name);
            chapterView = itemView.findViewById(R.id.novel_result_search_chapters);
        }
    }
}

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
import com.xuanthongn.data.model.NovelComment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NovelDetailsCommentAdapter extends RecyclerView.Adapter<NovelDetailsCommentAdapter.NovelDetailViewHolder> {

    private Context context;
    private List<NovelComment> novelscomments;

    public NovelDetailsCommentAdapter(Context context, List<NovelComment> novelscomments) {
        this.context = context;
        this.novelscomments = novelscomments;
    }

    @NonNull
    @Override
    public NovelDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_comment_item, parent, false);
        return new NovelDetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NovelDetailsCommentAdapter.NovelDetailViewHolder holder, int position) {
        NovelComment novelComment = novelscomments.get(position);
        Date date = novelComment.getNovelDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(date);
        holder.emailView.setText(novelComment.getEmail());
        holder.contentView.setText(novelComment.getContent());
        holder.chapterNumberView.setText("Chương: " + String.valueOf(novelComment.getNumber_of_chapters()));
        holder.dayNumberView.setText(formattedDate);
        holder.likeNumberView.setText(String.valueOf(novelComment.getNumber_of_likes()));
        holder.commentNumberView.setText(String.valueOf(novelComment.getNumber_of_comments()));


        //Set background image for layout

        Glide.with(holder.image.getContext())
                .load(novelComment.getImageUrl())
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
        TextView emailView;
        TextView contentView;
        TextView chapterNumberView;
        TextView dayNumberView;
        TextView likeNumberView;
        TextView commentNumberView;


        public NovelDetailViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.novel_detail_icon);
            emailView = itemView.findViewById(R.id.novel_detail_email);
            contentView = itemView.findViewById(R.id.novel_detail_content);
            chapterNumberView = itemView.findViewById(R.id.novel_detail_chapters);
            dayNumberView = itemView.findViewById(R.id.novel_detail_days);
            likeNumberView = itemView.findViewById(R.id.novel_detail_like);
            commentNumberView = itemView.findViewById(R.id.novel_detail_comment);

        }
    }
}

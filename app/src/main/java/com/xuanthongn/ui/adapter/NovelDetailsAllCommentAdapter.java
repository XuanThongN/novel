package com.xuanthongn.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.NovelComment;
import com.xuanthongn.util.CustomBindingAdapter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

public class NovelDetailsAllCommentAdapter extends RecyclerView.Adapter<NovelDetailsAllCommentAdapter.NovelDetailViewHolder> {

    private Context context;
    private List<NovelComment> novelscomments;

    public NovelDetailsAllCommentAdapter(Context context, List<NovelComment> novelscomments) {
        this.context = context;
        this.novelscomments = novelscomments;
    }

    @NonNull
    @Override
    public NovelDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new NovelDetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NovelDetailsAllCommentAdapter.NovelDetailViewHolder holder, int position) {
        NovelComment novelComment = novelscomments.get(position);
        LocalDateTime date = novelComment.getNovelDate();
        holder.usernameView.setText(novelComment.getEmail());
        holder.contentView.setText(novelComment.getContent());
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dt = formatter.format(Date.from(date.toInstant(ZoneOffset.UTC)));
        holder.timeView.setText(dt);
//        CustomBindingAdapter.loadImage(holder.image, novelComment.getImageUrl());
//        holder.image.setImageResource(android.R.drawable.screen_background_light);
    }

    @Override
    public int getItemCount() {
        return novelscomments.size();
    }

    public static class NovelDetailViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView usernameView;
        TextView contentView;
        TextView timeView;


        public NovelDetailViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.userAvatarImageView);
            usernameView = itemView.findViewById(R.id.usernameTextView);
            contentView = itemView.findViewById(R.id.commentContentTextView);
            timeView = itemView.findViewById(R.id.commentTimeLikesTextView);

        }
    }
}

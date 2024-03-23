package com.xuanthongn.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.BookMark;

import java.util.List;

public class BookMarkAdapter extends RecyclerView.Adapter<BookMarkAdapter.ViewHolder> {

    private Context context;
    private final List<BookMark> bookList;

    public BookMarkAdapter(Context context, List<BookMark> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookMark bookItem = bookList.get(position);
        holder.bookImage.setImageResource(bookItem.getImageResourceId());
        holder.bookCategory.setText(bookItem.getBookCategory());
        holder.bookTitle.setText(bookItem.getBookTitle());
        holder.chapterProgress.setText(bookItem.getChapterProgress());
        holder.deleteIcon.setImageResource(bookItem.getDeleteIconResourceId());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView bookImage;
        private TextView bookCategory;
        private TextView bookTitle;
        private TextView chapterProgress;
        private ImageView deleteIcon;

        public ViewHolder(View itemView) {
            super(itemView);

            bookImage = itemView.findViewById(R.id.book_cover);
            bookCategory = itemView.findViewById(R.id.book_category);
            bookTitle = itemView.findViewById(R.id.book_title);
            chapterProgress = itemView.findViewById(R.id.chapter_progress);
            deleteIcon = itemView.findViewById(R.id.delete_icon);
        }
    }
}

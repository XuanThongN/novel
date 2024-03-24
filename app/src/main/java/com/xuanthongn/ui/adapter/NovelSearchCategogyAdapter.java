package com.xuanthongn.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.Category;

import java.util.List;

public class NovelSearchCategogyAdapter extends RecyclerView.Adapter<NovelSearchCategogyAdapter.ViewNovelSearchCategoryHolder> {
    private Context context;
    private List<Category> categories;

    public NovelSearchCategogyAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public NovelSearchCategogyAdapter.ViewNovelSearchCategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_search_filter_item, parent, false);
        return new NovelSearchCategogyAdapter.ViewNovelSearchCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(NovelSearchCategogyAdapter.ViewNovelSearchCategoryHolder holder, int position) {
        Category categoryItem = categories.get(position);
        holder.nameView.setText(categoryItem.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewNovelSearchCategoryHolder extends RecyclerView.ViewHolder {
        TextView nameView;

        public ViewNovelSearchCategoryHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.rv_novel_search_category);
        }
    }
}

package com.xuanthongn.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.xuanthongn.R;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.ui.adapter.CategoryNovelItemAdapter.ViewHolder;

public class CategoryNovelItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<CategoryDto> categories;

    public CategoryNovelItemAdapter(Context context, List<CategoryDto> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.novel_category_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryDto categoryItem = categories.get(position);
        holder.nameView.setText(categoryItem.getName());
    }


    @Override
    public int getItemCount() {
        if (categories != null) {
            return categories.size();
        } else {
            return 0;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.category_novel_text_view);
        }
    }
}

package com.xuanthongn.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.CategoryItem;

import java.util.List;

public class CategoryItemAdapter extends BaseAdapter {

    private Context context;
    private List<CategoryItem> categories;

    public CategoryItemAdapter(Context context, List<CategoryItem> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);  // Inflate category_item.xml

        ImageView iconView = view.findViewById(R.id.category_icon);
        TextView nameView = view.findViewById(R.id.category_name);

        CategoryItem categoryItem = categories.get(position);
        iconView.setImageResource(categoryItem.getIconResId());
        nameView.setText(categoryItem.getName());

        return view;
    }
}

package com.xuanthongn.data.model;

public class CategoryItem {
    int iconResId;
    String name;

    public CategoryItem(int iconResId, String name) {
        this.iconResId = iconResId;
        this.name = name;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

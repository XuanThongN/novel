package com.xuanthongn.data.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.xuanthongn.data.entity.Category;
import com.xuanthongn.data.entity.Novel;

public class NovelWithCategory {
    @Embedded
    public Novel novel;

    @Relation(
            parentColumn = "category_id",
            entityColumn = "categoryId"
    )
    public Category category;
}
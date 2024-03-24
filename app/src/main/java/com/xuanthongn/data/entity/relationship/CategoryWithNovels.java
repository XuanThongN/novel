package com.xuanthongn.data.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.xuanthongn.data.entity.Category;
import com.xuanthongn.data.entity.Novel;

import java.util.List;

public class CategoryWithNovels {
    @Embedded
    public Category category;
    @Relation(
            parentColumn = "categoryId",
            entityColumn = "category_id"
    )
    public List<Novel> novels;
}

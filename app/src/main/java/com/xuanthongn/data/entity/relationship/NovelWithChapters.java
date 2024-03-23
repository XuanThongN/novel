package com.xuanthongn.data.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.xuanthongn.data.entity.Category;
import com.xuanthongn.data.entity.Chapter;
import com.xuanthongn.data.entity.Novel;

import java.util.List;

public class NovelWithChapters {
    @Embedded
    public Novel novel;
    @Relation(
            parentColumn = "novelId",
            entityColumn = "novel_id"
    )
    public List<Chapter> chapters;
}

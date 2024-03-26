package com.xuanthongn.data.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.xuanthongn.data.entity.Category;
import com.xuanthongn.data.entity.Chapter;
import com.xuanthongn.data.entity.Novel;

public class ChapterWithNovel {
    @Embedded
    public Chapter chapter;

    @Relation(
            parentColumn = "novel_id",
            entityColumn = "novelId"
    )
    public Novel novel;
}
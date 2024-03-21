package com.xuanthongn.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class Category {
    @PrimaryKey
    @ColumnInfo(name = "Id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;
}

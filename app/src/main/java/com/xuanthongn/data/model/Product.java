package com.xuanthongn.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {
    @PrimaryKey
    @ColumnInfo(name = "Id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "img")
    public String img;

    @ColumnInfo(name = "price")
    public double price;

    @ColumnInfo(name = "quantity")
    public int quantity;

    @ColumnInfo(name = "category_id")
    public int category_id;
}

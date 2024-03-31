package com.xuanthongn.data.model.response_model.user;

import com.google.gson.annotations.SerializedName;

public class CategoryResponseModel {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public CategoryResponseModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryResponseModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

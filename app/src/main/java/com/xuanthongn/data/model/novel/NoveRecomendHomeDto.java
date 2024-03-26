package com.xuanthongn.data.model.novel;

public class NoveRecomendHomeDto {
    public int novelId;
    public String name;
    public String imageUrl;
    public String categoryName;

    public NoveRecomendHomeDto() {
    }

    public NoveRecomendHomeDto(String name, String imageUrl, String categoryName) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
    }


    public int getNovelId() {
        return novelId;
    }
    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getCategory_id() {
        return categoryName;
    }
    public void setCategory_id(String categoryName) {
        this.categoryName = categoryName;
    }
}

package com.xuanthongn.data.model;

public class BookMark {
    private int ImageItemID;
    private String bookCategory;
    private String bookTitle;
    private String chapterProgress;
    private int deleteIconId;



    public BookMark(int imageItemID, String bookCategory, String bookTitle, String chapterProgress, int deleteIconId ) {
        this.ImageItemID = imageItemID;
        this.bookCategory = bookCategory;
        this.bookTitle = bookTitle;
        this.chapterProgress = chapterProgress;
        this.deleteIconId = deleteIconId;
    }

    public int getImageResourceId() {

        return ImageItemID;
    }

    public void setImageResourceId(int ImageItemID) {

        this.ImageItemID = ImageItemID;
    }

    public String getBookCategory() {

        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {

        this.bookCategory = bookCategory;
    }

    public String getBookTitle() {

        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {

        this.bookTitle = bookTitle;
    }

    public String getChapterProgress() {

        return chapterProgress;
    }

    public void setChapterProgress(String chapterProgress) {
        this.chapterProgress = chapterProgress;
    }

    public int getDeleteIconResourceId() {

        return deleteIconId;
    }

    public void setDeleteIconResourceId(int deleteIconId) {

        this.deleteIconId = deleteIconId;
    }
}

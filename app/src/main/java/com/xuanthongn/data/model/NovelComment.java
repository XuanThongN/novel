package com.xuanthongn.data.model;

import java.time.LocalDateTime;
import java.util.Date;

public class NovelComment {
    private int id;
    private String imageUrl;
    private String email;
    private String content;
    private int number_of_chapters;
    private LocalDateTime novelDate;
    private int number_of_likes;
    private int number_of_comments;

    public NovelComment(int id, String imageUrl, String email, String content, int number_of_chapters, LocalDateTime novelDate, int number_of_likes, int number_of_comments) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.email = email;
        this.content = content;
        this.number_of_chapters = number_of_chapters;
        this.novelDate = novelDate;
        this.number_of_likes = number_of_likes;
        this.number_of_comments = number_of_comments;
    }

    public NovelComment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getNovelDate() {
        return novelDate;
    }

    public void setNovelDate(LocalDateTime novelDate) {
        this.novelDate = novelDate;
    }

    public int getNumber_of_likes() {
        return number_of_likes;
    }

    public void setNumber_of_likes(int number_of_likes) {
        this.number_of_likes = number_of_likes;
    }

    public int getNumber_of_comments() {
        return number_of_comments;
    }

    public void setNumber_of_comments(int number_of_comments) {
        this.number_of_comments = number_of_comments;
    }

    public int getNumber_of_chapters() {
        return number_of_chapters;
    }

    public void setNumber_of_chapters(int number_of_chapters) {
        this.number_of_chapters = number_of_chapters;
    }
}

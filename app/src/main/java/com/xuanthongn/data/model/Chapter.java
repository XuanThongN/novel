package com.xuanthongn.data.model;

import java.util.Date;

public class Chapter {
    private int id;
    private String name;
    private String content;
    private Date chapter;

    public Chapter(int id, String name, Date chapter) {
        this.id = id;
        this.name = name;
        this.chapter = chapter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Chapter(int id, String name, String content, Date chapter) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.chapter = chapter;
    }

    public Chapter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Chapter() {
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Date getChapter() {return chapter;}
    public void setChapter(Date chapter) {this.chapter = chapter;}
}

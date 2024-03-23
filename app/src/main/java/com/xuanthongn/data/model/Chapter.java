package com.xuanthongn.data.model;

import java.util.Date;

public class Chapter {
    private int id;
    private String name;
    private Date chapter;

    public Chapter(int id, String name, Date chapter) {
        this.id = id;
        this.name = name;
        this.chapter = chapter;
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

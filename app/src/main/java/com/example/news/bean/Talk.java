package com.example.news.bean;

public class Talk {

    private String username;
    private String content;
    private String date;
    public Talk(String username,String content,String date){
        this.username=username;
        this.content=content;
        this.date=date;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }
}

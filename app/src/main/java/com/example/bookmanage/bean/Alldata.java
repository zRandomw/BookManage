package com.example.bookmanage.bean;

import java.util.List;

public class Alldata {
    private List<Book> data;
    private String message;

    public List<Book> getData() {
        return data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

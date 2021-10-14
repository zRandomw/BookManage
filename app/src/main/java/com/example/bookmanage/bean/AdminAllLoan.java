package com.example.bookmanage.bean;

import java.util.List;

public class AdminAllLoan {
    List<Myinform> data;
    private String message;

    public List<Myinform> getData() {
        return data;
    }

    public void setData(List<Myinform> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.example.bookmanage.bean;

import java.util.List;

public class AllLoanBook {
    private List<Loan> data;
    private String message;

    public List<Loan> getData() {
        return data;
    }

    public void setData(List<Loan> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

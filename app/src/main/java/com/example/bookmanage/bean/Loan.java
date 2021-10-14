package com.example.bookmanage.bean;

public class Loan {
    private Integer loanid;

    private String loanTime;

    private String returnTime;

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    private Integer bookofid;

    private Integer loanuserid;

    private String isreturn;

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getBookofid() {
        return bookofid;
    }

    public void setBookofid(Integer bookofid) {
        this.bookofid = bookofid;
    }

    public Integer getLoanuserid() {
        return loanuserid;
    }

    public void setLoanuserid(Integer loanuserid) {
        this.loanuserid = loanuserid;
    }

    public String getIsreturn() {
        return isreturn;
    }

    public void setIsreturn(String isreturn) {
        this.isreturn = isreturn;
    }
}

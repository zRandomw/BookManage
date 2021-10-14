package com.example.bookmanage.bean;

public class Book {

        private Integer id;

        private String bookName;

        private String bookInfo;

        private String bookImage;

        private Integer bookStatus;

    public Integer getid() {
        return id;
    }

    public void setBookid(Integer bookid) {
        this.id = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }
}

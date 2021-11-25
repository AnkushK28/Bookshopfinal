package com.perennial.model;

import java.util.ArrayList;

public class Book {
    private String ISBN;
    private String bookName;
    private ArrayList<String> Author;
    private User user;
    private String status;

    public Book(String ISBN, String bookName, ArrayList<String> author, User user,String status) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        Author = author;
        this.user = user;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", bookName='" + bookName + '\'' +
                ", Author=" + Author +
                ", user=" + user +
                ", status='" + status + '\'' +
                '}';
    }

    public ArrayList<String> getAuthor() {
        return Author;
    }

    public void setAuthor(ArrayList<String> author) {
        Author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}





package com.perennial.model;

import java.util.ArrayList;

public class Book {
    private String ISBN;
    private String BookName;
    private String AuthorName;
    private Owner owner;

    public String getISBN() {
        return ISBN;
    }

    public String getBookName() {
        return BookName;
    }


    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public Owner getOwner() {
        return owner;
    }

    public Book(String ISBN, String bookName, String authorName, Owner owner) {
        this.owner = owner;
        this.ISBN = ISBN;
        BookName = bookName;
        AuthorName = authorName;
    }
    @Override
    public String toString() {
        return "Book{" +
                " " + owner +
                "ISBN='" + ISBN + '\'' +
                ", BookName='" + BookName + '\'' +
                ", AuthorName=" + AuthorName +

                '}';
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }
}



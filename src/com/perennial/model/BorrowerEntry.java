package com.perennial.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BorrowerEntry extends Book {

    private String BookName;
    private LocalDate issuedate;
    private LocalDate returndate;
    private User borrower;
    private Book book;


    @Override
    public String toString() {
        return "BorrowerEntry{" +
                "BookName='" + BookName + '\'' +
                ", issuedate=" + issuedate +
                ", returndate=" + returndate +
                ", borrower=" + borrower +
                '}';
    }

    public BorrowerEntry(String bookName, LocalDate issuedate, User borrower) {
        BookName = bookName;
        this.issuedate = issuedate;
        this.borrower = borrower;

    }

    public String getBookName() {
        return BookName;
    }

    public LocalDate getIssuedate() {
        return issuedate;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public User getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setIssuedate(LocalDate issuedate) {
        this.issuedate = issuedate;
    }

}




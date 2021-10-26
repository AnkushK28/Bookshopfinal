package com.perennial.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BorrowerEntry {

    private String BookName;
    private SimpleDateFormat issuedate;
    private LocalDate returndate;
    private User borrower;
    private Book book;



    @Override
    public String toString() {
        return "BorrowerEntry{" +
                "BookName='" + BookName + '\'' +
                ", issuedate=" + issuedate +
                ", returndate=" + returndate +
                "," + borrower +
                '}';
    }

    public BorrowerEntry(String bookName, SimpleDateFormat issuedate, User borrower) {
        BookName = bookName;
        this.issuedate = issuedate;
        this.borrower = borrower;
    }

    public String getBookName() {
        return BookName;
    }

    public SimpleDateFormat getIssuedate() {
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

    public void setIssuedate(SimpleDateFormat issuedate) {
        this.issuedate = issuedate;
    }

}




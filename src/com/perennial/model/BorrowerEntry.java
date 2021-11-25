package com.perennial.model;

import java.time.LocalDate;

public class BorrowerEntry {

    private String BookName;
    private LocalDate issuedate;
    private LocalDate returndate;
    private User borrower;
    private Book book;

    public LocalDate getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(LocalDate issuedate) {
        this.issuedate = issuedate;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BorrowerEntry{" +
                "bookName=" + BookName +
                ", issuedate=" + issuedate +
                ", returndate=" + returndate +
                ", borrower=" + borrower +
                ",book=" + book +
                '}';

    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }


}




package com.perennial.model;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import com.perennial.model.Owner;
public class BookService {
    Scanner sc = new Scanner(System.in);
    Map<Integer, BorrowerEntry> register = new HashMap<>();
    List<Book> booklist = new ArrayList<>();
    List<Owner> ownerlist = new ArrayList<>();
    List<User> userlist = new ArrayList<>();
    ArrayList<BorrowerEntry> BorrowerIssue = new ArrayList<BorrowerEntry>();
    List<BorrowerEntry> Borrower = new ArrayList<>();

    public void addbook() {
        System.out.println("Enter a owner name");
        String name = sc.next();
        System.out.println("Entea owner mobile number");
        int mobileno = sc.nextInt();
        System.out.println("Enter Book name : ");
        String bookName = sc.next();
        System.out.println("Enter ISBN : ");
        String ISBN = sc.next();
        System.out.println("Author names : ");
        String authorName = sc.next();
        Owner o = new Owner(name, mobileno);
        ownerlist.add(o);
        Book b = new Book(ISBN, bookName, authorName, o);
        booklist.add(b);
        System.out.println("SUCCESSFULLY BOOK ADDED");
    }

    public void showbook() {
        booklist.forEach(book -> System.out.println(book.toString()));
    }

    public void IssuedBook() {
        System.out.println("Enter a BookName");
        String bookName = sc.next();
        System.out.println("Enter a Borrower Name");
        String borrowername = sc.next();
        System.out.println("Enter a Borrower Mobile Number");
        long mobile = sc.nextLong();
        User u = new User(borrowername, mobile);
        userlist.add(u);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        BorrowerEntry be = new BorrowerEntry(bookName, formatter, u);
        BorrowerIssue.add(be);
        Borrower.add(be);
        int c = 0;
        for (int i = 0; i < Borrower.size(); i++) {
            if (bookName.equalsIgnoreCase(Borrower.get(i).getBookName())) {
                c = 1;
                Borrower.remove(be);
                System.out.println("BOOK IS SUCCESFULLY BORROWED");
            } else {
                System.out.println("Book is allready borrowed");
            }
//                if (bookName.equalsIgnoreCase(be.getBookName())) {
//                    c = 2;
//                    break;
//                }
        }
    }
//        if (c == 1) {
//            for (int j = 0; j < BorrowerIssue.size(); j++) {
//                if (!bookName.equalsIgnoreCase(BorrowerIssue.get(j).getBookName())) {
//                    System.out.println("BOOK IS ALREADY BORROWED BY"+);
//
//                }
//                else
//                {
//                    System.out.println("BOOK IS SUCCESFULLY BORROWED");
//
//                }
//            }


    public void searchbook() {
        System.out.println("You can search book  \n 1]Book Name \n 2]ISBN \n 3]Author Name");
        System.out.println("Enter Choice : ");
        int choice = sc.nextInt();
        if (choice == 1) {
            int c = 0;
            System.out.println("Enter book name which you want to search:-");
            sc.nextLine();
            System.out.println("Enter Book Name:");
            String nameOfBook = sc.nextLine();
            for (int i = 0; i < booklist.size(); i++) {
                if (nameOfBook.equalsIgnoreCase(booklist.get(i).getBookName())) {
                    c = 1;
                    System.out.println(booklist.get(i).toString());
                    System.out.println("Book available");
                }
            }

            if (c == 0) {
                System.out.println("Book not available");
            }

        }
        if (choice == 2) {
            int c = 0;
            System.out.println("Enter ISB number which you want to search:-");
            sc.nextLine();
            System.out.println("Enter ISB number : ");
            String ISBNumber = sc.nextLine();
            for (int i = 0; i < booklist.size(); i++)
            {
                if (ISBNumber.equalsIgnoreCase(booklist.get(i).getISBN())) {
                    c=1;
                    System.out.println(booklist.get(i).toString());
                    System.out.println("Book for this ISB number is available");

                }

            }
            if (c == 0) {
                System.out.println("No Book for this ISB number ");
            }

        }
        if (choice == 3) {
            int c = 0;
            System.out.println("Enter author name want to search:-");
            sc.nextLine();
            System.out.println("Enter Author Name:");
            String authorN = sc.next();
            for (int i = 0; i < booklist.size(); i++) {

                if (authorN.equalsIgnoreCase(booklist.get(i).getAuthorName())) {
                    c = 1;
                    System.out.println(booklist.get(i).toString());
                    System.out.println("BOOK IS AVAILABLE");

                }

            }
            if (c == 0) {
                System.out.println("NOT AVAILABLE");
            }

        }
    }


}





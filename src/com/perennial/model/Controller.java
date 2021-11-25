package com.perennial.model;

import java.time.LocalDate;
import java.util.*;

public class Controller
{
    Bookservice bookService = new Bookservice();

    public void operation() {

        System.out.println("***************************WELCOME BOOKDIARY***********************************");
        System.out.println("Press 1 to add Book");
        System.out.println("Press 2 IssueBook");
        System.out.println("Press 3 to Search book");
        System.out.println("Press 4 to Return book ");
        System.out.println("Press 5 to Discontinue book");
        System.out.println("Press 6 to Show Details of book");

        Scanner sc = new Scanner(System.in);
        Integer option = sc.nextInt();
        switch (option) {
            case 1:
                ArrayList<String> authorList = new ArrayList<>();

                System.out.println("Enter a owner name");
                String ownerName = sc.next();

                System.out.println("Enter owner mobile number");
                Long ownerMobile = sc.nextLong();
                User user = new User(ownerName, ownerMobile);

                System.out.println("Enter Book name : ");

                String bookName = sc.next();

                System.out.println("Enter ISBN : ");

                String ISBN = sc.next();

                System.out.println("Author names : ");
                String authorName = sc.next();

                String[] array = authorName.split(",");
                HashSet<String> authorSet = new HashSet<>(Arrays.asList(array));
                String[] authorsArray = authorSet.toArray(new String[0]);
                authorList.add(authorName);

                String status="Available";
                Book book = new Book(ISBN, bookName, authorList, user,status);
                System.out.println("book added succesfully");
                bookService.addBook(book);
                operation();
                break;

            case 2:

                BorrowerEntry borrowerEntry = new BorrowerEntry();
                System.out.println("Enter a BookName");
                String nameOfBook = sc.next();
                System.out.println("Enter a Borrower Name");
                String borrowerName = sc.next();
                System.out.println("Enter a Borrower Mobile Number");
                long mobileNumber = sc.nextLong();
                User borrower = new User(borrowerName, mobileNumber);
                borrowerEntry.setBookName(nameOfBook);
                borrowerEntry.setIssuedate(LocalDate.now());
                borrowerEntry.setBorrower(borrower);
                bookService.issuedBook(borrower, borrowerEntry);
                operation();
                break;

            case 3:
                System.out.println("You can search book  \n 1]Book Name \n 2]ISBN \n 3]Author Name");
                System.out.println("Enter Choice : ");
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("Enter book name which you want to search:-");
                    sc.nextLine();
                    System.out.println("Enter Book Name:");
                    String searchBookName = sc.nextLine();
                    List<Book> bookList=bookService.searchBookByBookName(searchBookName);
                    if(bookList.size()==0)
                    {
                        System.out.println("no book found");
                    }
                    else
                    {
                        bookList.forEach(book1 -> System.out.println(book1.toString()));
                    }

                    operation();
                    break;

                }
                if (choice == 2) {
                    System.out.println("Enter ISB number which you want to search:-");
                    sc.nextLine();
                    System.out.println("Enter ISB number : ");
                    String ISBNumber = sc.next();
                    List<Book> bookList= bookService.searchBookByISBN(ISBNumber);
                    if(bookList.size()==0)
                    {
                        System.out.println("no book found");
                    }
                    else
                    {
                        bookList.forEach(book1 -> System.out.println(book1.toString()));
                    }
                    operation();
                    break;
                }
                if(choice==3)
                {

                    System.out.println("Enter author name:");
//                    String nameOfAuthor = sc.next();
                    List<String> searchAuthorName = Collections.singletonList(sc.next());
                    bookService.searchBookByAuthorName(searchAuthorName);
                    operation();
                    break;
                }

                break;
            case 4:
                System.out.println("Enter Book Name:");
                String returnBookName = sc.next();
                bookService.returnBook(returnBookName);
                operation();
                break;

            case 5:
                System.out.println("Enter a bookName");
                String discontinueBookName = sc.next();
                bookService.discontinue(discontinueBookName);
                operation();
                break;
//
//            case 7:
//                bookService.history();
//                operation();
//                break;
//
//        }
        }

    }
    public static void main(String[] args)
    {
        Controller C=new Controller();
        C.operation();
    }
}



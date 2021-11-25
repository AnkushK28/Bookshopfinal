package com.perennial.model;
import java.time.LocalDate;
import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.stream.Collectors;

public class Bookservice {
    ArrayList<Book> bookList = new ArrayList<>();
    static Map<String, Book> bookMap = new HashMap<>();
    Map<String, BorrowerEntry> borrowerEntryMap = new HashMap<>();
    List<BorrowerEntry> borrowerEntryList = new ArrayList<>();
    private static Logger logger = LogManager.getLogger(Bookservice.class);

    public void addBook(Book book) {
        {
            bookList.add(book);
            bookMap.put(book.getBookName(), book);
        }
    }
    public void issuedBook(User Borrower, BorrowerEntry borrowerEntry)
    {
        if (bookMap.containsKey(borrowerEntry.getBookName())) {
            borrowerEntry.setIssuedate(LocalDate.now());
            borrowerEntryMap.put(borrowerEntry.getBookName(), borrowerEntry);
            for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
                if (borrowerEntry.getBookName().equalsIgnoreCase(entry.getKey())) {
                    borrowerEntry.setBook(entry.getValue());
                    break;
                }
            }
            Book book = bookMap.get(borrowerEntry.getBookName());
           book.setStatus("not available");
           bookMap.put(borrowerEntry.getBookName(),book);
            borrowerEntryList.add(borrowerEntry);
            System.out.println(bookMap.get(borrowerEntry.getBookName()).toString());

        } else if (borrowerEntryMap.containsKey(borrowerEntry.getBookName())) {
            logger.error("BOOK ALLREADY BORROWED");
        } else {
         logger.error("BOOK IS NOT IN LIST");
        }

    }


    public List<Book> searchBookByBookName(String bookName) {

        List<Book> nameofbook = bookList.stream().filter(p -> (p.getBookName().contains(bookName) && p.getStatus()=="Available")).collect(Collectors.toList());
        return nameofbook;
    }


    public List<Book> searchBookByISBN(String ISBN) {
        List<Book> bookWithISBN = bookList.stream().filter(p -> (p.getISBN().contains(ISBN) && p.getStatus()=="Available")).collect(Collectors.toList());
        return bookWithISBN;
    }

    public static void searchBookByAuthorName(List<String> authorlist)
    {
        int n = authorlist.size();
        Map<String, Book> bookMap1 = bookMap.entrySet().stream().filter(e -> e.getValue().getAuthor().get(n).contains(authorlist.get(n))).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        {
            bookMap1.forEach((key, value) ->
            {
                logger.error(key + "|" + bookMap1.get(value).getBookName() + "|" + bookMap1.get(value).getISBN() + "|" + bookMap1.get(value).getAuthor());
            });

        }
    }

    public void discontinue(String discontinueBookName) {
//        for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
//            if (bookMap.containsKey(discontinueBookName)) {
//                bookMap.remove(discontinueBookName);
//                logger.info("Discontinue book successfull");
//            }
//        }
        bookMap.entrySet().stream().filter(t -> t.getValue().equals(discontinueBookName)).
                forEach(t -> bookMap.remove(t.getKey()));
        bookMap.entrySet().removeIf(entry -> entry.getValue().equals(discontinueBookName));
        logger.error("Discontinue book successfull");
//        bookMap.entrySet().stream().filter(e->e.getKey().equalsIgnoreCase(discontinueBookName)).findFirst().get();
//        Optional<Map.Entry<String, String>> optionalEntry = bookMap.containsKey(discontinueBookName).filter(e -> e.getValue().equals("Donkey")).findFirst();
//        keyOfTheFirst = optionalEntry.isPresent() ? optionalEntry.get().getKey() : null;
//       List<Book> bookwithName = bookList.stream().collect(Collectors.mapping());
////        return bookwithName;
//        Map<String, Book> discontinueBook = bookMap.stream().filter(e -> e.getValue().getAuthor().get(n).contains(authorlist.get(n))).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
//    }

    }

    public void returnBook(String returnBookName)
    {
        if (borrowerEntryMap.containsKey(returnBookName))
        {
            for (BorrowerEntry entry : borrowerEntryList) {
                bookMap.put(returnBookName, entry.getBook());
                LocalDate returnDate = LocalDate.now();
                entry.setReturndate(returnDate);
                borrowerEntryMap.remove(returnBookName);
               logger.info("book return successfully " + entry.toString());
                break;
            }
        } else {
           logger.info("Book is not in store");

        }
    }
}







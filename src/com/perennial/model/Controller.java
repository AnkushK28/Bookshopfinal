package com.perennial.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller
{
      BookService bookService = new BookService();

        public void operation()
        {

            System.out.println("***********WELCOME BOOKDIARY***************");
        System.out.println("Press 1 to add Book");
        System.out.println("Press 2 Issue Book");
        System.out.println("Press 3 Show All books");
        System.out.println("Press 4 to Search book");
        System.out.println("Press 5 to Discontinue book");
        System.out.println("Press 6 to Show Details of book");
        Scanner in = new Scanner(System.in);
        Integer option = in.nextInt();
        switch (option) {
            case 1:

                bookService.addbook();
                operation();
                break;

            case 2:
                bookService.IssuedBook();
                operation();
                break;

            case 3:
                 bookService.showbook();
                 operation();
                break;

            case 4:
                bookService.searchbook();
                operation();
                break;

            case 5:
                bookService.Discontinue();
                operation();
                break;

        }
    }

}

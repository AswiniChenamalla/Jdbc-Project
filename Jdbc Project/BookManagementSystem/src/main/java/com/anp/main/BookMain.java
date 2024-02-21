package com.anp.main;
import java.util.List;

import java.util.Scanner;

import com.anp.dao.BookDao;
import com.anp.daoImpl.BookDaoImpl;
import com.anp.entities.Book;

public class BookMain {

    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl();
        Scanner sc = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("***BOOK MANAGEMENT SYSTEM***");
            System.out.println("--Menu Options--");
            System.out.println("1. Add Book to List");
            System.out.println("2. Get Book by BookId");
            System.out.println("3. Get All Books");
            System.out.println("4. Update the Book Details");
            System.out.println("5. Delete the Book From List");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice (1-6): ");
            int choice = sc.nextInt();
            sc.nextLine(); 
 
        switch (choice) {
            case 1: // add book
                System.out.print("Enter BookID: ");
                int bookId = sc.nextInt();
                sc.nextLine(); 
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Name of the Author: ");
                String author = sc.nextLine();
                System.out.print("Enter Name of the Genre: ");
                String genre = sc.nextLine();
                System.out.print("Enter Year Published: ");
                int publicationYear = sc.nextInt();
                sc.nextLine(); 
                System.out.print("Enter Name of the Publisher: ");
                String publisher = sc.nextLine();
                System.out.print("Enter Name of the Language: ");
                String language = sc.nextLine();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                Book bookToAdd = new Book(bookId, title, author, genre, publicationYear, publisher, language, price);
                bookDao.addBook(bookToAdd);
                System.out.println("Book added successfully!");
                break;
                
            case 2: // get book by Id
                System.out.print("Enter BookID to be searched: ");
                int searchBookId = sc.nextInt();
                bookDao.getBookbyId(searchBookId);
                break;
                
            case 3: // get all books
                List<Book> allBooks = bookDao.getAllBooks();
                if (allBooks.isEmpty()) {
                    System.out.println("No books available.");
                } else {
                    System.out.println("List of all books:");
                    for (Book book : allBooks) {
                        System.out.println(book);
                    }
                }
                break;


            case 4: // update book details
                System.out.print("Enter BookID to be updated: ");
                int updateBookId = sc.nextInt();
                sc.nextLine(); 
                
                System.out.print("Enter the new Title: ");
                String newTitle = sc.nextLine();
                
                Book bookToUpdate = new Book(updateBookId, newTitle, "", "", 0, "", "", 0.0);
                bookDao.updateBook(bookToUpdate);
                break;

            case 5: // delete book
                System.out.print("Enter BookID to be deleted: ");
                int deleteBookId = sc.nextInt();
                bookDao.deleteBook(deleteBookId);
                break;

            case 6: // exit
                System.out.println("Exiting the Book Management System. Goodbye!");
                exit = true;
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                break;
        }

        if (!exit) {
            System.out.print("Do you want to make another choice? (y/n): ");
            char continueChoice = sc.next().charAt(0);
            if (continueChoice != 'y' && continueChoice != 'Y') {
                exit = true;
                System.out.println("Exiting the Book Management System. Goodbye!");
            }
        }
    }

    sc.close(); 
}
}
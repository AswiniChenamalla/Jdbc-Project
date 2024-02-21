package com.anp.dao;

import java.util.List;

import com.anp.entities.Book;

public interface BookDao {
	// create Book table
	void createBookTable();
	
	// Add a new book to the Book table
    void addBook(Book book);
    
    // Display all books in the Book table by BookId
    void getBookbyId(int bookId);
    
    // Display all books in the Book Table
    List<Book> getAllBooks();
    
    // Delete a book from the Book table by bookId
    void deleteBook(int bookId);
    
    // Update details of a book in the Book table
    void updateBook(Book book);
    

}

package com.anp.daoImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anp.dao.BookDao;
import com.anp.entities.Book;

@SuppressWarnings("serial")
class BookAlreadyExistsException extends Exception{
	public static void BookAlreadyExistsExceptions() {
		System.out.println("WELCOME TO THE BOOK STORE");
	}
	}
public class BookDaoImpl implements BookDao {
	String jdbcUrl = "jdbc:mysql://localhost:3306/BookManagementSystem";
    String username = "root";
    String password = "Admin123";

	@Override
	public void createBookTable() {
	    String createTable = "CREATE TABLE Book(BookId INT PRIMARY KEY,"
	            + "Title VARCHAR(50),"
	            + "Author VARCHAR(50),"
	            + "Genre VARCHAR(50),"
	            + "publicationYear INT, "
	            + "publisher VARCHAR(255), "
	            + "Language VARCHAR(50), "
	            + "Price DOUBLE)";
	    try {
	        Connection con = DriverManager.getConnection(jdbcUrl, username, password);
	        PreparedStatement pts = con.prepareStatement(createTable);
	        pts.execute();
	        System.out.println("Table is created successfully");
	        System.out.println();

	    } catch (Exception e) {
	        System.out.println("Error creating table: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	@Override
	public void addBook(Book book) {
		String insertQuery = "insert into Book(BookId,Title,Author,Genre,PublicationYear,Publisher,Language,Price) Values(?,?,?,?,?,?,?,?)";;
		try {
			Connection con = DriverManager.getConnection(jdbcUrl,username,password);
			PreparedStatement pts = con.prepareStatement(insertQuery);
			pts.setInt(1, book.getBookId());
			pts.setString(2, book.getTitle());
			pts.setString(3,book.getAuthor());
			pts.setString(4, book.getGenre());
			pts.setInt(5, book.getPublicationYear());
			pts.setString(6, book.getPublisher());
			pts.setString(7, book.getLanguage());
			pts.setDouble(8, book.getPrice());
			
			pts.executeUpdate();
			System.out.println("Book is Inserted successfully");
		} catch (Exception e) {
			//BookAlreayExitsException.BookAlreadyExistsExceptions();
			e.printStackTrace();
			}
	}

	@Override
	public void getBookbyId(int bookId) {
		String displayBookbyId = "select * from Book where BookId=?";
		try (
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement pts = con.prepareStatement(displayBookbyId)) {
				pts.setInt(1, bookId);
				ResultSet rs = pts.executeQuery();
				if(rs.next()) {
					int BookId = rs.getInt("BookId");
					String Title = rs.getString("Title");
					String Author = rs.getString("Author");
					String Genre = rs.getString("Genre");
					int PublicationYear = rs.getInt("PublicationYear");
					String Publisher = rs.getString("Publisher");
					String Language = rs.getString("Language");
					double Price = rs.getDouble("price");
					
					System.out.println("BookId is - "+BookId);
					System.out.println("Title is - "+Title);
					System.out.println("Author is - "+Author);
					System.out.println("Genre is - "+Genre);
					System.out.println("PublicationYear is - "+PublicationYear);
					System.out.println("Publisher is - "+Publisher);
					System.out.println("Language is - "+Language);
					System.out.println("Price  is - "+Price);
					System.out.println();
				}
				else {
					System.out.println("Book doesnot Found.....err");
				}
			}
	catch(Exception e) {
		e.printStackTrace();
	  }
	}
	@Override
	 public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String displayAllBooks = "SELECT * FROM Book";
        try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement pts = con.prepareStatement(displayAllBooks);
             ResultSet rs = pts.executeQuery()) {

            while (rs.next()) {
	            int bookId = rs.getInt("BookId");
	            String title = rs.getString("Title");
	            String author = rs.getString("Author");
	            String genre = rs.getString("Genre");
	            int publicationYear = rs.getInt("PublicationYear");
	            String publisher = rs.getString("Publisher");
	            String language = rs.getString("Language");
	            double price = rs.getDouble("Price");

	            System.out.println("BookId: " + bookId);
	            System.out.println("Title: " + title);
	            System.out.println("Author: " + author);
	            System.out.println("Genre: " + genre);
	            System.out.println("PublicationYear: " + publicationYear);
	            System.out.println("Publisher: " + publisher);
	            System.out.println("Language: " + language);
	            System.out.println("Price: " + price);
	            System.out.println();
	        }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve all books: " + e.getMessage());
            e.printStackTrace();
        }
        return books;
    }

	
	@Override
	public void deleteBook(int bookId) {
		String deleteBook = "delete from Book where BookId =?";

	try (
		Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement pts = con.prepareStatement(deleteBook)) {
		pts.setInt(1, bookId);
		int rowsDeleted = pts.executeUpdate();
		if(rowsDeleted>0) {
			System.out.println("Book deleted successfully from the list");
		}
		else {
			System.out.println("Failed to delete the book from list .. the book you are trying to delete  may not exits");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}

	@Override
	public void updateBook(Book book) {
		String UpdateBookdtl = "update Book Set Title=? where BookId=?";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl,username,password);
			PreparedStatement pts = con.prepareStatement(UpdateBookdtl);
			pts.setString(1, book.getTitle());
			pts.setInt(2, book.getBookId());
			pts.executeUpdate();
			System.out.println("Book details are updated successfully");
		} catch (SQLException e) {
			System.out.println("failed to update the details of the book:"+e.getMessage());
			e.printStackTrace();
	
		}
		
	}
	
}

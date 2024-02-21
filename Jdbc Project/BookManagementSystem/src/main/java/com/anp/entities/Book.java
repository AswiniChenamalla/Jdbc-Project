package com.anp.entities;

public class Book {
	
	private int BookId;
	private String Title;
	private String Author;
	private String Genre;
	private int PublicationYear;
	private String Publisher;
	private String Language;
	private double Price;
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public int getPublicationYear() {
		return PublicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		PublicationYear = publicationYear;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		this.Publisher = publisher;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	public Book(int bookId, String title, String author, String genre, int publicationYear, String publisher,
			String language, double price) {
		super();
		this.BookId = bookId;
		this.Title = title;
		this.Author = author;
		this.Genre = genre;
		this.PublicationYear = publicationYear;
		this.Publisher = publisher;
		this.Language = language;
		this.Price = price;
	}

}

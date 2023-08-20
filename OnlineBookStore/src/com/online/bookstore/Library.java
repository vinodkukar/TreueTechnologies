package com.online.bookstore;
import java.util.*;

public class Library {

	private List<Book> books;
	public Library() {
		books = new ArrayList<>();
		books.add(new Book(1,"Book 1", "Author 1"));
		books.add(new Book(2,"Book 2","Author 2"));
		books.add(new Book(3,"Book 3","Author 3"));
	}
	public List<Book> getAllBooks()
	{
		return books;
	}
	public List<Book> getAvailableBooks()
	{
		List<Book> availableBooks = new ArrayList<>();
		for(Book book : books)
		{
			if(book.isAvailable)
			{
				availableBooks.add(book);
			}
		}
		return availableBooks;
	}
	public void addBook(int id, String title, String author)
	{
		books.add(new Book(id,title,author));
	}
	public Book getBookById(int id)
	{
		for(Book book : books)
		{
			if(book.id == id)
			{
				return book;
			}
		}
		return null;
	}
	public void borrowBook(int id)
	{
		Book book = getBookById(id);
		if(book == null){
			System.out.println("Book with ID" + id + " not found");
			return;
		}
		if(!book.isAvailable)
		{
			System.out.println("Book with ID " + id + "is not available for borrowing.");
			return;
		}
		book.isAvailable = false;
		System.out.println("Book with ID " + id + " has been borrowed.");
	}
	public void returnBook(int id)
	{
		Book book = getBookById(id);
		if(book == null)
		{
			System.out.println("Book with ID "+ id + "not found");
			return;
		}
		if(book.isAvailable)
		{
			System.out.println("Book with ID "+ id + "is already available");
			return;
		}
 	 	System.out.println("Book with Id"+ id + "has been returned");
	}
	public void rateAndReviewBook(int id, int rating, String review)
	{
		Book book = getBookById(id);
		if(book==null)
		{
			System.out.println("Book with ID" + id + "not found");
			return;
		}
		if(rating <1 || rating>5)
		{
			System.out.println("Invalid rating. Rating should be on a scale of 1 to 5");
			return;
		}
		book.totalRatingPoints +=rating;
		book.numRatings++;
		book.review = review;
		
		System.out.println("Book with ID" + id + "has been rated and reviewed.");
	}
}

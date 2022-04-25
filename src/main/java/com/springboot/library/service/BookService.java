package com.springboot.library.service;

import java.util.List;

import com.springboot.library.entity.Book;

public interface BookService 
{
	public List<Book> getAllBooks();
	
	public Book getBookById(int id);
	
	public Book addBook(Book book);
	
	public void deleteBook(int id);
	
	public void updateBook(int id,Book book);
}

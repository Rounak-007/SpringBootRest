package com.springboot.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.library.entity.Book;
import com.springboot.library.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public BookServiceImpl()
	{}
	
	public List<Book> getAllBooks() {
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) {
		Book book=null;
		try {
			book=this.bookRepository.findById(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		Book newBook=bookRepository.save(book);
		return newBook;
	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

	public void updateBook(int id, Book book) {
		// TODO Auto-generated method stub
		book.setBookcode(id);
		bookRepository.save(book);
	}

}

package com.springboot.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_details")
public class Book 
{
	@Id
	@Column(unique=true)
	private int bookcode;
	private String bookname;
	private String authorname;
	private String dateAdded;
	
	public Book() {
		
	}

	public Book(int bookcode, String bookname, String authorname, String dateAdded) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.authorname = authorname;
		this.dateAdded = dateAdded;
	}

	public Book(String bookname, String authorname, String dateAdded) {
		super();
		this.bookname = bookname;
		this.authorname = authorname;
		this.dateAdded = dateAdded;
	}

	public int getBookcode() {
		return bookcode;
	}

	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
}

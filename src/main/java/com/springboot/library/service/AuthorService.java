package com.springboot.library.service;

import java.util.List;

import com.springboot.library.entity.Author;

public interface AuthorService {
	
	  public List<Author> getAllAuthors();
	  
	  public Author getAuthorById(int id);
	  
	  public Author addAuthor(Author author);
	  
	  public void deleteAuthor(int id);
	  
	  public void updateAuthor(int id,Author author);
	 

	/*public List<Author> findAll();

	public Author findById(int id);

	public void save(Author author);

	public void update(Author author);
*/
}

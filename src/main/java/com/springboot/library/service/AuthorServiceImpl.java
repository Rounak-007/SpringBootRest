package com.springboot.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.library.entity.Author;
import com.springboot.library.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public AuthorServiceImpl() {
		super();
	}

	public List<Author> getAllAuthors() {
		List<Author> authors = (List<Author>) this.authorRepository.findAll();
		return authors;
	}

	public Author getAuthorById(int authorid) {
		Author author = this.authorRepository.findById(authorid);
		return author;
	}

	public Author addAuthor(Author author) {
		Author newAuthor = this.authorRepository.save(author);
		return newAuthor;
	}

	public void deleteAuthor(int authorid) {
		// TODO Auto-generated method stub
		this.authorRepository.deleteById(authorid);
	}

	public void updateAuthor(int authorid, Author author) {
		// TODO Auto-generated method stub
		author.setId(authorid);
		this.authorRepository.save(author);
	}
	
	
	/*public List<Author> findAll()
	{
		return (List<Author>) authorRepository.findAll();
	}
	
	public Author findById(int id)
	{
		return this.authorRepository.findById(id);
	}
	
	public void save(Author author)
	{
		this.authorRepository.save(author);
	}
	
	public void update(Author author)
	{
		authorRepository.update(author.getCode(), author.getName());
	}*/
}

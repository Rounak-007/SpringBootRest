package com.springboot.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.library.entity.Author;
import com.springboot.library.service.AuthorService;

@RestController
public class AuthorRestController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/getauthors")
	public ResponseEntity<List<Author>> getAuthors()
	{
		List<Author> list=this.authorService.getAllAuthors();
		
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	}
	
	@GetMapping("/getauthor/{authorId}")
	public ResponseEntity<Author> getAuthor(@PathVariable("authorId") int authorId)
	{
		Author author=this.authorService.getAuthorById(authorId);
		if(author==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(author));
	}
	
	@PostMapping("/addauthors")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author)
	{
		try{
			Author newaAuthor=this.authorService.addAuthor(author);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/deleteauthor/{authorid}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable("authorid") int authorId)
	{
		try {
			this.authorService.deleteAuthor(authorId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/editauthor/{authorid}")
	public ResponseEntity<Void> editAuthor(@PathVariable("authorid")int authorId,@RequestBody Author author )
	{
		try {
			this.authorService.updateAuthor(authorId, author);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*@GetMapping("/ListAuthors")
	public Author[] list(Author author)
	{
		List<Author> authorList=authorService.findAll();
		Author[] authorArray=new Author[authorList.size()];
		authorList.toArray(authorArray);
		
		return authorArray;
	}
	
	@GetMapping("/UpdateAuthor/{id}")
	public Author edit(@RequestParam("id")int id)
	{
		Author author=authorService.findById(id);
		return author;
	}
	
	@PostMapping("/addAuthor")
	public @ResponseBody Author[] addData(@RequestBody Author author)
	{
		authorService.save(author);
		List<Author> authorList=authorService.findAll();
		Author[] authorArray=new Author[authorList.size()];
		authorList.toArray(authorArray);
		
		return authorArray;
		
	}
	
	@PostMapping("/updateAuthor")
	public Author[] updateData(@RequestBody Author author)
	{
		authorService.update(author);
		
		List<Author> authorList=authorService.findAll();
		Author[] authorArray=new Author[authorList.size()];
		authorList.toArray(authorArray);
		
		return authorArray;
	}*/
}

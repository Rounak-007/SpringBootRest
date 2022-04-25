package com.springboot.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.library.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
	public Author findById(int id);

	/*@Transactional
	@Modifying
	@Query("update Author set name= :name where code= :code")
	void update(@RequestParam("code") String code, @RequestParam("name") String name);*/

}

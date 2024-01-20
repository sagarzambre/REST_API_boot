package com.boot.restapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.restapi.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
	public Book findById(int id);
}

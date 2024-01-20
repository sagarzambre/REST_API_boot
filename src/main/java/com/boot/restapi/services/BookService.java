package com.boot.restapi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.restapi.dao.BookRepository;
import com.boot.restapi.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
//	private static List<Book> booklist = new ArrayList<Book>();
//	static {
//		booklist.add(new Book(3,"Head first to java", "abc"));
//		booklist.add(new Book(2123,"Java: complete reference", "XYZ"));
//		booklist.add(new Book(1,"Python", "jack"));
//	}
	public List<Book> getAllBooks(){
		List<Book> booklist = (List<Book>)this.bookRepository.findAll();
		return booklist;
	}
	
	public Book getBookById(int id) {
//		for (Book b:booklist) {
//			if(b.getId() == id)
//				return b;
//		}
//		return null;
		
		Book b = this.bookRepository.findById(id);
		return b;
	}
	
	public Book addBook(Book b) {
//		booklist.add(b);
//		return b;
		Book book = this.bookRepository.save(b);
		return book;
	}
	
	public void deleteBook(int id) {
//		Iterator<Book> itr = booklist.iterator();
//		while(itr.hasNext()) {
//			if(itr.next().getId() == id)
//				itr.remove();
//		}
		this.bookRepository.deleteById(id);

	}
	public void updateBook(Book book, int id) {
//		Iterator<Book> itr = booklist.iterator();
//		int index = 0;
//		while(itr.hasNext()) {
//			if(itr.next().getId() == id) {
//				booklist.set(index, book);
//				break;
//			}
//			index++;
//		}
		book.setId(id);
		this.bookRepository.save(book);
	}
}

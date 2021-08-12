package com.dematic.testtask.bookstorage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dematic.testtask.bookstorage.entity.Book;
import com.dematic.testtask.bookstorage.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getAll(){
		List<Book> theBooks = bookService.getBooks();   
		return theBooks;
	}
	
	@PostMapping("/books")
	public void save(@RequestBody Book book) {
		bookService.saveBook(book);
		System.out.println(book.toString());
	}
	
	@GetMapping("/books/{id}")
	public Book getOne(@PathVariable Integer id) {
		Book book = bookService.getBook(id);
		System.out.println(id);
		return book;
	}
	
	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable Integer id) {
		System.out.println("need to remove " + id);
		bookService.deleteBook(id);
	}
}


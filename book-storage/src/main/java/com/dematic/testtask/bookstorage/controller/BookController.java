package com.dematic.testtask.bookstorage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dematic.testtask.bookstorage.entity.Book;

@RestController
public class BookController {
	
	public static Map<Integer,Book> books;
	
	/*@PostConstruct
	public void Data() {
		books = new ArrayList<>();
		
		Book book1 = new Book();
		book1.setId(1);
		book1.setName("Riders on the storm");
		book1.setAuthor("Andry Morgan");
		book1.setBarcode((long) 1258749632);
		book1.setQuantity(5);
		book1.setPrice(85.14);
		book1.setYear(2017);
		
		books.add(book1);
		//books.add(new Book(1, "Riders on the storm", "Andry Morgan", (long) 1258749632, 5, 81.36, 2017, 0));
	}*/
	
	static {
		books = new HashMap<>();
		
		Book book1 = new Book();
		book1.setId(1);
		book1.setName("Riders on the storm");
		book1.setAuthor("Andry Morgan");
		book1.setBarcode((long) 1258749632);
		book1.setQuantity(5);
		book1.setPrice(85.14);
		book1.setYear(2017);
		
		books.put(book1.getId(), book1);
	}

	@GetMapping("/books")
	public List<Book> getAll(){
		System.out.println("KON");
		
		List<Book> listBooks = new ArrayList<>(books.values());
		return listBooks;
	}
	
	@PostMapping("/books")
	public void save(@RequestBody Book book) {
		books.put(book.getId(), book);
		System.out.println(book.toString());
	}
	
	@GetMapping("/books/{id}")
	public Book getOne(@PathVariable int id) {
		Book book = books.get(id);
		System.out.println(id);
		return book;
	}
	
	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("need to remove " + id);
		books.remove(id);
	}
}


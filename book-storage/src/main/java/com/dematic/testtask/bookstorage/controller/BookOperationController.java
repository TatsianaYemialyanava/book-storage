package com.dematic.testtask.bookstorage.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dematic.testtask.bookstorage.entity.Book;
import com.dematic.testtask.bookstorage.service.BookService;

@RestController
public class BookOperationController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books/getByBarcode/{barcode}")
	public Book getByBarcode(@PathVariable Long barcode) {
		Book result = bookService.findBookByBarcode(barcode);
		return result;
	}
	
	@GetMapping("/books/getAnticBooks")
	public List<Book> getAnticBooks() {
		List<Book> result = bookService.findAllAnticBooks();
		return result;
	}
	
	@GetMapping("/books/getScienceJornals")
	public List<Book> getScienceJornals() {
		List<Book> result = bookService.findAllScienceJornals();
		return result;
	}
	
	@PostMapping("/books/updateBookInfoByBarcode/{barcode}")
	public void patchChanges(@PathVariable Long barcode, @RequestBody Book book) {
		bookService.patchСhanges(barcode, book);
	}
    
    @GetMapping("/books/getTotalPriceByBarcode/{barcode}")
	public Double getTotalPrice(@PathVariable Long barcode) {
		Double totalPrice = bookService.countTotalPriceByBarcode(barcode);
		System.out.println(totalPrice);
		return totalPrice; 
	} 
	
	@GetMapping("/books/getAllBarcodesByQuantity")
	public Map<Integer, List<Long>> getAllBarcodes(){
		Map<Integer, List<Long>> barcodesMap = bookService.getAllBarcodesGroupByQuantity(); 
		return barcodesMap;
	}
}

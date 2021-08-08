package com.dematic.testtask.bookstorage.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dematic.testtask.bookstorage.entity.Book;

@RestController
public class BookOperationController {
	
	@GetMapping("/books/getByBarcode/{barcode}")
	public Book getByBarcode(@PathVariable long barcode) {
		Book result = null;
		Collection<Book> booksFromMap = BookController.books.values();
		for(Book el: booksFromMap) {
			if(barcode == el.getBarcode()) {
				result = el;
				break;
			}
		}
		return result;
	}
	
	@PatchMapping("/books/updateBookInfoByBarcode/{barcode}")
	public void saveChanges(@RequestBody Book book, @PathVariable long barcode) {
		/*Book bookForSaving = new Book();
		int id = 0;
		if(book.getId() != 0) {
			id = book.getId();
		}
		bookForSaving.setId(id);
		String name;
		private String author;
		private long barcode;
		private int quantity;
		private double price;
		private int year;
		private int scIndex;
		
		
		Book result = null;
		Collection<Book> booksFromMap = BookController.books.values();
		for(Book el: booksFromMap) {
			if(barcode == el.getBarcode()) {
				result = el;
				break;
			}
			Сделать эксептши по id and barcode!
			*
			*/
		System.out.println("I will do it");
	} 
	
	@GetMapping("/books/getTotalPriceByBarcode/{barcode}")
	public Double getTotalPrice(@PathVariable long barcode) {
		final int ANTIQ_COEF = 10;
		Book book = null;
		Double resultPrice = null; 
		LocalDateTime date = LocalDateTime.now();
		
		Collection<Book> booksFromMap = BookController.books.values();
		for(Book el: booksFromMap) {
			if(barcode == el.getBarcode()) {
				book = el;
				break;
			}
		}
		if(book.getYear() < 1900) {
			resultPrice = book.getQuantity() * book.getPrice() * ((date.getYear() - book.getYear()) / ANTIQ_COEF);
		} else if (book.getScIndex() > 0 & book.getScIndex() < 11) {
			resultPrice = book.getQuantity() * book.getPrice() * book.getScIndex();
		}else {
			resultPrice = book.getQuantity() * book.getPrice();
		}
		return resultPrice;
	} 
	
	@GetMapping("/books/getAllBarcodesByQuantity")
	public Map<Integer, List<Long>> getAllBarcodes(){
		Map<Integer, List<Long>> barcodesMap = new HashMap<>();
		List<Long> listBarcodes = new ArrayList<>();
		listBarcodes.add((long) 1547859654);
		listBarcodes.add((long) 1547859764);
		barcodesMap.put(5, listBarcodes);
		return barcodesMap;
	}

}




















/*@PatchMapping("/customers/{id}")
public ResponseEntity < ? > updateResource(@RequestParam("email") String email, @PathVariable("id") String id) {
 Customer newCustomer = customerService.updateCustomer(email, id);
 return new ResponseEntity < > (newCustomer, HttpStatus.OK);
}






/*
 * @RequestMapping(value = "/manager/{id}", method = RequestMethod.PATCH)
public @ResponseBody void saveManager(@PathVariable Long id, @RequestBody Map<Object, Object> fields) {
    Manager manager = someServiceToLoadManager(id);
    // Map key is field name, v is value
    fields.forEach((k, v) -> {
       // use reflection to get field k on manager and set it to value v
        Field field = ReflectionUtils.findField(Manager.class, k);
        field.setAccessible(true);
        ReflectionUtils.setField(field, manager, v);
    });
    managerService.saveManager(manager);
}
 * 
 * @PatchMapping("/heavyresource/{id}")
public ResponseEntity<?> partialUpdateName(
  @RequestBody HeavyResourceAddressOnly partialUpdate, @PathVariable("id") String id) {
    
    heavyResourceRepository.save(partialUpdate, id);
    return ResponseEntity.ok("resource address updated");
}*/









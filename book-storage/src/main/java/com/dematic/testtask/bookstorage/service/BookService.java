package com.dematic.testtask.bookstorage.service;

import java.util.List;
import java.util.Map;
import com.dematic.testtask.bookstorage.entity.Book;

public interface BookService {
	
	public List<Book> getBooks();
	
	public void saveBook(Book book);
	
	public Book getBook(Integer id);

	public void deleteBook(Integer id);
	
	public Book findBookByBarcode(Long barcode);
	
	public List<Book> findAllAnticBooks();
	
	public List<Book> findAllScienceJornals();
	
	public Double countTotalPriceByBarcode(Long barcode);
	
	public Map<Integer, List<Long>> getAllBarcodesGroupByQuantity();
	
	public void patchСhanges(Long barcode,Book book);
}

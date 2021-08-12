package com.dematic.testtask.bookstorage.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.dematic.testtask.bookstorage.entity.Book;

public interface BookOperationRepository {
	
	@Query(value = "SELECT * FROM books WHERE barcode = ?", nativeQuery=true)
	public Book findBookByBarcode(Long barcode);
	
	@Query(value = "SELECT * FROM books WHERE year < 1900", nativeQuery=true)
	public List<Book> findAllAnticBooks();
	
	@Query(value = "SELECT * FROM books WHERE sc_index BETWEEN 1 AND 10", nativeQuery=true)
	public List<Book> findAllScienceJornals();

}

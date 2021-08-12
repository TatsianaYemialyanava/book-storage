package com.dematic.testtask.bookstorage.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dematic.testtask.bookstorage.dao.BookRepository;
import com.dematic.testtask.bookstorage.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	@Transactional
	public List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	@Transactional
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	@Transactional
	public Book getBook(Integer id) {
		Book book = null;
		Optional<Book> optionalBook = bookRepository.findById(id);
		 if (!optionalBook.isPresent()) {
			 throw new BookNotFoundException();
		 }
		 book = optionalBook.get();
		 return book;
	}

	@Override
	@Transactional
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Book findBookByBarcode(Long barcode) {
		Book book = bookRepository.findBookByBarcode(barcode);
		if(book == null) {
			throw new BookNotFoundException();
		}
		return book;
	}
	
	@Override
	@Transactional
	public List<Book> findAllAnticBooks() {
		List<Book> anticBooks = bookRepository.findAllAnticBooks();
		return anticBooks;
	}

	@Override
	@Transactional
	public List<Book> findAllScienceJornals() {
		List<Book> scJornals = bookRepository.findAllScienceJornals();
		return scJornals;
	}

	@Override
	@Transactional
	public Double countTotalPriceByBarcode(Long barcode) {
		Book book = bookRepository.findBookByBarcode(barcode);
		if(book == null) {
			throw new BookNotFoundException();
		}
		
		final int ANTIQ_COEF = 10;
		Double result = null;
		LocalDateTime date = LocalDateTime.now();
		
		if(book.getYear() != null && book.getYear() < 1900) {
			result = book.getQuantity() * book.getPrice() * (date.getYear() - book.getYear()) / ANTIQ_COEF;
		} else if (book.getScIndex() != null && (book.getScIndex() > 0 & book.getScIndex() < 11)) {
			result = book.getQuantity() * book.getPrice() * book.getScIndex();
		}else {
			result = book.getQuantity() * book.getPrice();
		}
		System.out.println(result);
		return result;
	}

	@Override
	@Transactional
	public Map<Integer, List<Long>> getAllBarcodesGroupByQuantity() {
		
		Map<Integer, List<Long>> result = new HashMap<>();
		List<Book> books = (List<Book>) bookRepository.findAll();
		List <Long> barcodes = null;
		
		for(int i = 0; i < books.size(); i++) {
			if(result.containsKey(books.get(i).getQuantity())){
				List<Long> currentBarcodes = result.get(books.get(i).getQuantity());
				currentBarcodes.add(books.get(i).getBarcode());
				result.put(books.get(i).getQuantity(), currentBarcodes);
			}else {
				barcodes = new ArrayList<>();
				barcodes.add(books.get(i).getBarcode());
				result.put(books.get(i).getQuantity(), barcodes);
			}
		}
		System.out.println(result.toString());
		return result;
	}

	@Override
	@Transactional
	public void patchСhanges(Long barcode, Book book) {
		Book existedBook = bookRepository.findBookByBarcode(barcode);
		if(book == null) {
			throw new BookNotFoundException();
		}
		if(book.getName() != null) {
			existedBook.setName(book.getName());
		}
		if(book.getAuthor() != null) {
			existedBook.setAuthor(book.getAuthor());
		}
		if(book.getQuantity() != null){
			existedBook.setQuantity(book.getQuantity());
		}
		if(book.getPrice() != null) {
			existedBook.setPrice(book.getPrice());
		}
		if(book.getYear() != null) {
			existedBook.setYear(book.getYear());
		}
		if(book.getScIndex() != null) {
			existedBook.setScIndex(book.getScIndex());
		}
		bookRepository.save(existedBook);
	}
}

package com.dematic.testtask.bookstorage.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dematic.testtask.bookstorage.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}

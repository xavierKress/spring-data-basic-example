package com.xavierkress.springdata.basicExample.repositories;


import com.xavierkress.springdata.basicExample.model.Book;
import org.springframework.data.repository.Repository;

public interface BookRepository extends Repository<Book, Long> {

}

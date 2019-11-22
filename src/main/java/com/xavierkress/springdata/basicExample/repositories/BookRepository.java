package com.xavierkress.springdata.basicExample.repositories;


import com.xavierkress.springdata.basicExample.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitleContains(String title);

}

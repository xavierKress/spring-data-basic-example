package com.xavierkress.springdata.basicExample.repositories;


import com.xavierkress.springdata.basicExample.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitleContains(String title);

}

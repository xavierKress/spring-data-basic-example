package com.xavierkress.springdata.basicExample.repositories;


import com.xavierkress.springdata.basicExample.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>, BookRepositoryCustom {

    List<Book> findByTitleContains(@Param("title") String title);

    List<Book> findAll(Sort sort);

    Page<Book> findAll(Pageable pageable);

}

package com.xavierkress.springdata.basicExample.repositories;


import com.xavierkress.springdata.basicExample.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends BaseRepository<Book, Long> {

}

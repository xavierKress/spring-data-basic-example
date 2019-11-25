package com.xavierkress.springdata.basicExample;

import com.xavierkress.springdata.basicExample.model.Book;
import com.xavierkress.springdata.basicExample.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class BookRepositoryIntegrationTests {

    @Autowired
    private BookRepository books;

    private Book book, book2, book3, book4, book5;

    @BeforeEach
    void setUp() {
        book = new Book(1L, "book1", "ISBN1");
        book2 = new Book(2L, "book2", "ISBN2");
        book3 = new Book(3L, "book3", "ISBN2");
        book4 = new Book(4L, "book4", "ISBN2");
        book5 = new Book(5L, "book5", "ISBN2");

        List<Book> customers = Arrays.asList(book, book2, book3, book4, book5);
        books.saveAll(customers);
    }

    @Test
    public void findBook() {
        List<Book> result = books.findByTitleContains(book.getTitle());
        assertEquals(book, result.get(0));

        List<Book> descSortedBooks = books.findAll(Sort.by("title").descending());

        assertEquals("book5", descSortedBooks.get(0).getTitle());
        assertEquals("book4", descSortedBooks.get(1).getTitle());


        Pageable pageable = PageRequest.of(0, 2, Sort.by("title").descending());
        Page<Book> pagedSortedBooks = books.findAll(pageable);

        assertEquals(3, pagedSortedBooks.getTotalPages());
        assertEquals(5, pagedSortedBooks.getTotalElements());


    }
}

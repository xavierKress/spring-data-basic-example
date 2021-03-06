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
    private Sort byTitleDescending;
    private List<Book> resultBooks;

    @BeforeEach
    void setUp() {
        resultBooks = books.findAll();
        byTitleDescending = Sort.by("title").descending();
    }


    @Test
    public void findBook() {
        List<Book> result = books.findByTitleContains(book.getTitle());
        assertEquals(book, result.get(0));
    }

    @Test
    public void findSortedBooks(){
        List<Book> descSortedBooks = books.findAll(byTitleDescending);
        System.out.println(descSortedBooks);
        // Test the order
        assertEquals(resultBooks.get(4), descSortedBooks.get(0));
        assertEquals(resultBooks.get(3), descSortedBooks.get(1));
        assertEquals(resultBooks.get(2), descSortedBooks.get(2));
        assertEquals(resultBooks.get(1), descSortedBooks.get(3));
        assertEquals(resultBooks.get(0), descSortedBooks.get(4));
    }

    @Test
    public void customMethod() {

        Book b = books.myCustomMethod();
        assertEquals(null, b);
    }

    @Test
    public void pageAndSort(){


        Pageable pageable = PageRequest.of(0, 2, byTitleDescending);
        Page<Book> pagedSortedBooks = books.findAll(pageable);

        Pageable pageable2 = PageRequest.of(2, 2, byTitleDescending);
        Page<Book> paged2SortedBooks = books.findAll(pageable2);

        List<Book> pagedBooks = pagedSortedBooks.getContent();
        List<Book> pagedBooks2 = paged2SortedBooks.getContent();

        assertEquals(0, pagedSortedBooks.getNumber());
        assertEquals(2, paged2SortedBooks.getNumber());
        assertEquals(2, pagedSortedBooks.getSize());
        assertEquals(3, pagedSortedBooks.getTotalPages());
        assertEquals(5, pagedSortedBooks.getTotalElements());
        assertEquals(true, pagedSortedBooks.isFirst());
        assertEquals(true, paged2SortedBooks.isLast());
        assertEquals(2, pagedBooks.size());
        assertEquals(1, pagedBooks2.size());
    }

    @Test
    public void testCallbacks(){
        Book b = new Book("title", "isbn");
        books.save(b);
        books.flush();
    }

}

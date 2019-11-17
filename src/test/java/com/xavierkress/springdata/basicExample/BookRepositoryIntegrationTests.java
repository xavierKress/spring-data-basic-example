package com.xavierkress.springdata.basicExample;

import com.xavierkress.springdata.basicExample.model.Book;
import com.xavierkress.springdata.basicExample.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class BookRepositoryIntegrationTests {

    @Autowired
    private BookRepository books;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book(1L, "book1", "ISBN1");
        books.insertBook(book.getId(), book.getTitle(), book.getIsbn());
    }

    @Test
    public void findBook(){
        List<Book> result = books.findByTitleContains(book.getTitle());
        assertEquals(book, result.get(0));
    }
}

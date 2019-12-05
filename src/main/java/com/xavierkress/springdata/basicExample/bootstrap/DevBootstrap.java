package com.xavierkress.springdata.basicExample.bootstrap;

import com.xavierkress.springdata.basicExample.model.Book;
import com.xavierkress.springdata.basicExample.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository books;
    private Book book, book2, book3, book4, book5;

    public DevBootstrap(BookRepository books) {
        this.books = books;
    }

    private void initData() {
        book = new Book("book1", "ISBN1");
        book2 = new Book("book2", "ISBN2");
        book3 = new Book("book3", "ISBN3");
        book4 = new Book("book4", "ISBN4");
        book5 = new Book("book5", "ISBN5");

        List<Book> newBooks = Arrays.asList(book, book2, book3, book4, book5);
        books.saveAll(newBooks);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
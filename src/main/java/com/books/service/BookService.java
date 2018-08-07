package com.books.service;

import com.books.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService
{
    List<Book> findAll();

    Optional<Book> findById(String id);

    Book saveAndFlush(Book book);

    void deleteBook(Book book);

    void deleteById(String id);

    void deleteAll();
}

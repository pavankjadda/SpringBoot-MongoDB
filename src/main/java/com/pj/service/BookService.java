package com.pj.service;

import com.pj.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService
{
    List<Book> findAll();

    Optional<Book> findById(String id);

    Book insertBook(Book book);

    void insertAllBooks(Iterable<Book> book);

    Book updateBook(Book book);

    void deleteBook(Book book);

    void deleteById(String id);

    void deleteAll();
}

package com.books.service;

import com.books.model.Book;
import com.books.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl    implements BookService
{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository=bookRepository;
    }

    @Override
    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(String id)
    {
        return bookRepository.findById(id);
    }

    @Override
    public Book insertBook(Book book)
    {
        return bookRepository.insert(book);
    }

    @Override
    public Book updateBook(Book book)
    {
        return bookRepository.save(book);
    }
    @Override
    public void deleteBook(Book book)
    {
        bookRepository.delete(book);
    }

    @Override
    public void deleteById(String id)
    {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll()
    {
        bookRepository.deleteAll();
    }
}

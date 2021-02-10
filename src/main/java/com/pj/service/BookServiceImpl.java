package com.pj.service;

import com.pj.model.Book;
import com.pj.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl  implements BookService
{

    private final BookRepository bookRepository;

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
    public void insertAllBooks(Iterable<Book> books)
    {
        bookRepository.insert(books);
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

package com.pj.service;

import com.pj.model.Book;
import com.pj.repo.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class that handles business logic to get, create, update Books
 *
 * @author Pavan Kumar Jadda
 * @since 2.0.0
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Find all books
     *
     * @return List of all books
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Find the book by ID
     *
     * @param id ID of the book that needs to be found
     *
     * @return Book matching the given ID
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @Override
    public Optional<Book> findById(String id) {
        return bookRepository.findById(id);
    }

    /**
     * Save the new book
     *
     * @param book an object that contains new book information
     *
     * @return Created book
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @Override
    public Book insertBook(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    public void insertAllBooks(Iterable<Book> books) {
        bookRepository.insert(books);
    }

    /**
     * Update the book
     *
     * @param book an object that contains updated book information
     *
     * @return Updated book
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Delete book by ID
     *
     * @param id ID of the book that needs to be deleted
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }
}

package com.pj.web;

import com.pj.model.Book;
import com.pj.repo.BookReactiveRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Provides Reactive API endpoints for Book operations
 *
 * @author Pavan Kumar Jadda
 * @since 2.1.0
 */
@RestController
@RequestMapping("/api/v1/book/reactive")
public class BookReactiveController {
    private final BookReactiveRepository bookReactiveRepository;

    public BookReactiveController(BookReactiveRepository bookReactiveRepository) {
        this.bookReactiveRepository = bookReactiveRepository;
    }

    /**
     * Find all books
     *
     * @return List of all books asynchronously
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @GetMapping("/find/all")
    public Flux<Book> getBooks() {
        return bookReactiveRepository.findAll();
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
    @GetMapping("/find/id/{id}")
    public Mono<Book> getBookById(@PathVariable Long id) {
        return bookReactiveRepository.findById(id);
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
    @PostMapping("/save")
    public Mono<Book> saveBook(@RequestBody Book book) {
        return bookReactiveRepository.insert(book);
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
    @PutMapping("/update")
    public Mono<Book> updateBook(@RequestBody Book book) {
        return bookReactiveRepository.insert(book);
    }

    /**
     * Delete book by ID
     *
     * @param id ID of the book that needs to be deleted
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteBook(@PathVariable Long id) {
        return bookReactiveRepository.deleteById(id);
    }
}

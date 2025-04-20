package com.pj.web;

import com.pj.model.Book;
import com.pj.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Provides API endpoints for Book operations
 *
 * @author Pavan Kumar Jadda
 * @since 2.1.0
 */
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    /**
     * Find all books
     *
     * @return List of all books
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @GetMapping("/find/all")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(service.findAll());
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
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
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
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(service.insertBook(book));
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
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(service.updateBook(book));
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
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        service.deleteById(id);
        return new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);
    }
}
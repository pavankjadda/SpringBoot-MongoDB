package com.books.web;

import com.books.model.Book;
import com.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController
{
    private BookService bookService;

    @Autowired
    public BookController(BookService   bookService)
    {
        this.bookService=bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable String id)
    {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping("/books/save_book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book)
    {
        return ResponseEntity.ok(bookService.insertBook(book));
    }

    @PutMapping("/books/update_book")
    public ResponseEntity<Book> updateBook(@RequestBody Book book)
    {
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id)
    {
        bookService.deleteById(id);
        return new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);
    }

}

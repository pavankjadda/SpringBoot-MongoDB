package com.pj.web;

import com.pj.model.Book;
import com.pj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController
{
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService)
	{
		this.bookService = bookService;
	}

	@GetMapping("/find/all")
	public ResponseEntity<List<Book>> getBooks()
	{
		return ResponseEntity.ok(bookService.findAll());
	}

	@GetMapping("/find/id/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable String id)
	{
		return ResponseEntity.ok(bookService.findById(id));
	}

	@PostMapping("/save")
	public ResponseEntity<Book> saveBook(@RequestBody Book book)
	{
		return ResponseEntity.ok(bookService.insertBook(book));
	}

	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book)
	{
		return ResponseEntity.ok(bookService.updateBook(book));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable String id)
	{
		bookService.deleteById(id);
		return new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);
	}
}

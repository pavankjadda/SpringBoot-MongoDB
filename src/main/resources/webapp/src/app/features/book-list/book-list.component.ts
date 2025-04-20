import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../../models/book';
import { BookService } from '../../services/book.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  imports: [CommonModule],
})
export class BookListComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService, private router: Router) {}

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks(): void {
    this.bookService.getAllBooks().subscribe((books) => (this.books = books));
  }

  editBook(id: string): void {
    this.router.navigate(['/edit-book', id]);
  }

  deleteBook(id: string): void {
    if (confirm('Are you sure you want to delete this book?')) {
      this.bookService.deleteBook(id).subscribe(() => {
        this.loadBooks();
      });
    }
  }
}

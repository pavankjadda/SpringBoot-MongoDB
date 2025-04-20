import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../../models/book';
import { BookService } from '../../services/book.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  imports: [CommonModule,ReactiveFormsModule],
})
export class BookFormComponent implements OnInit {
  bookForm: FormGroup;
  isEditMode = false;
  bookId: string | null = null;

  constructor(
    private fb: FormBuilder,
    private bookService: BookService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.bookForm = this.fb.group({
      title: ['', Validators.required],
      numberOfPages: ['', [Validators.required, Validators.min(1)]],
      cost: ['', [Validators.required, Validators.min(0)]],
      author: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.bookId = this.route.snapshot.paramMap.get('id');
    if (this.bookId) {
      this.isEditMode = true;
      this.loadBook(this.bookId);
    }
  }

  loadBook(id: string): void {
    this.bookService.getBookById(id).subscribe(book => {
      this.bookForm.patchValue(book);
    });
  }

  onSubmit(): void {
    if (this.bookForm.valid) {
      const book: Book = this.bookForm.value;
      if (this.isEditMode && this.bookId) {
        book.id = this.bookId;
        this.bookService.updateBook(book).subscribe(() => {
          this.router.navigate(['/books']);
        });
      } else {
        this.bookService.createBook(book).subscribe(() => {
          this.router.navigate(['/books']);
        });
      }
    }
  }
}

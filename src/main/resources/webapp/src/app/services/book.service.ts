import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiUrl = '/api/v1/book';

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.apiUrl}/find/all`);
  }

  getBookById(id: string): Observable<Book> {
    return this.http.get<Book>(`${this.apiUrl}/find/id/${id}`);
  }

  createBook(book: Book): Observable<Book> {
    return this.http.post<Book>(`${this.apiUrl}/save`, book);
  }

  updateBook(book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.apiUrl}/update`, book);
  }

  deleteBook(id: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}
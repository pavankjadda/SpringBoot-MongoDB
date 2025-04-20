import { Routes } from '@angular/router';
import { BookListComponent } from './features/book-list/book-list.component';
import { BookFormComponent } from './features/book-form/book-form.component';

export const routes: Routes = [
  { path: '', redirectTo: '/books', pathMatch: 'full' },
  { path: 'books', component: BookListComponent },
  { path: 'add-book', component: BookFormComponent },
  { path: 'edit-book/:id', component: BookFormComponent }
];;

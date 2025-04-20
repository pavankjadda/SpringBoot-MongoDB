import { Routes } from '@angular/router';
import { BookFormComponent } from './features/book-form/book-form.component';
import { BookListComponent } from './features/book-list/book-list.component';
import { CustomerFormComponent } from './features/customer-form/customer-form.component';
import { CustomerListComponent } from './features/customer-list/customer-list.component';

export const routes: Routes = [
  { path: '', redirectTo: '/books', pathMatch: 'full' },
  { path: 'books', component: BookListComponent },
  { path: 'add-book', component: BookFormComponent },
  { path: 'edit-book/:id', component: BookFormComponent },
  { path: 'customers', component: CustomerListComponent },
  { path: 'add-customer', component: CustomerFormComponent },
  { path: 'edit-customer/:id', component: CustomerFormComponent },
];

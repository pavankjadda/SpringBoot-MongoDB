import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = '/api/v1/customer';

  constructor(private http: HttpClient) { }

  findByFirstName(firstName: string): Observable<Customer> {
    return this.http.get<Customer>(`${this.apiUrl}/find/first_name/${firstName}`);
  }

  findByLastName(lastName: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.apiUrl}/find/last_name/${lastName}`);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.apiUrl}/save`, customer);
  }
}
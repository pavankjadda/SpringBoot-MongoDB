import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../../models/customer';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  imports: [CommonModule, FormsModule],
  standalone: true
})
export class CustomerListComponent {
  customers: Customer[] = [];
  searchTerm: string = '';
  searchBy: 'firstName' | 'lastName' = 'lastName';

  constructor(private customerService: CustomerService, private router: Router) {}

  search(): void {
    if (!this.searchTerm.trim()) return;

    if (this.searchBy === 'firstName') {
      this.customerService.findByFirstName(this.searchTerm).subscribe(customer => {
        this.customers = customer ? [customer] : [];
      });
    } else {
      this.customerService.findByLastName(this.searchTerm).subscribe(customers => {
        this.customers = customers;
      });
    }
  }

  editCustomer(customer: Customer): void {
    this.router.navigate(['/edit-customer', customer.id]);
  }

  addCustomer(): void {
    this.router.navigate(['/add-customer']);
  }
}

import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Customer } from '../../models/customer';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  imports: [CommonModule, RouterLink],
  standalone: true,
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];

  constructor(
    private customerService: CustomerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customerService
      .getAllCustomers()
      .subscribe((customers) => (this.customers = customers));
  }

  editCustomer(id: string): void {
    this.router.navigate(['/edit-customer', id]);
  }

  deleteCustomer(id: string): void {
    if (confirm('Are you sure you want to delete this customer?')) {
      this.customerService.deleteCustomer(id).subscribe(() => {
        this.loadCustomers();
      });
    }
  }
}

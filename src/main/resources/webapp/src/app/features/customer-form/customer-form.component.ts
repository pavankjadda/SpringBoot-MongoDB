import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Customer } from '../../models/customer';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
})
export class CustomerFormComponent implements OnInit {
  customerForm: FormGroup;
  isEditMode = false;
  customerId: string | null = null;

  constructor(
    private fb: FormBuilder,
    private customerService: CustomerService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.customerForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.customerId = this.route.snapshot.paramMap.get('id');
    if (this.customerId) {
      this.isEditMode = true;
      // Since we don't have a getById endpoint, we can pre-populate from state if available
      const navigation = this.router.getCurrentNavigation();
      const customer = navigation?.extras?.state?.['customer'];
      if (customer) {
        this.customerForm.patchValue(customer);
      }
    }
  }

  onSubmit(): void {
    if (this.customerForm.valid) {
      const customer: Customer = this.customerForm.value;
      if (this.isEditMode && this.customerId) {
        customer.id = this.customerId;
      }

      this.customerService.saveCustomer(customer).subscribe(() => {
        this.router.navigate(['/customers']);
      });
    }
  }
}

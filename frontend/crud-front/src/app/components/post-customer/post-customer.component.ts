import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-post-customer',
  templateUrl: './post-customer.component.html',
  styleUrls: ['./post-customer.component.css']
})
export class PostCustomerComponent {

  postCustomerForm!: FormGroup;

  constructor(private customerService:CustomerService, private fb: FormBuilder) { }

  ngOnInit(){
    this.postCustomerForm = this.fb.group({
      name: [null, [Validators.required, Validators.minLength(3)]],
      email: [null, [Validators.required, Validators.email]],
      phone: [null, [Validators.required]]
    })
  }

  postCustomer(){
    console.log(this.postCustomerForm.value);
    this.customerService.postCustomer(this.postCustomerForm.value).subscribe((res) => {
      console.log(res);
      alert('Customer added successfully');
    })
  }

  voltar(){
    window.location.href = 'http://localhost:4200';
  }

}

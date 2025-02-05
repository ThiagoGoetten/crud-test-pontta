import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent {

  updateCustomerForm!: FormGroup;

  id: number = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private service: CustomerService, private fb:FormBuilder) { }

  ngOnInit() {
    this.updateCustomerForm = this.fb.group({
      name: [null, [Validators.required, Validators.minLength(3)]],
      email: [null, [Validators.required, Validators.email]],
      phone: [null, [Validators.required]]
    })
    this.getCustomerById()
  }

  getCustomerById(){
    this.service.getCustomerById(this.id).subscribe((res) => {
      console.log(res);
      this.updateCustomerForm.patchValue(res);
  })
} 

  updateCustomer(){
    this.service.updateCustomer(this.id, this.updateCustomerForm.value).subscribe((res) => {
      console.log(res);
      alert('Customer updated successfully'); 
      if(res.id != null){       
      }
    })
  }

  voltar(){
    window.location.href = 'http://localhost:4200';
  }

}

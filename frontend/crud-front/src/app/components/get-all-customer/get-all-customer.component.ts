import { Component } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';


@Component({
  selector: 'app-get-all-customer',
  templateUrl: './get-all-customer.component.html',
  styleUrls: ['./get-all-customer.component.css']
})
export class GetAllCustomerComponent {


    customers: any = [];

   constructor(private customerService: CustomerService) { }

    ngOnInit() {
      this.getAllCustomers();
    }

    getAllCustomers() {
      this.customerService.getAllCustomer().subscribe((res) => {
        console.log(res)
        this.customers = res;
      })
    }

    deleteCustomer(id: number) {
      this.customerService.deleteCustomer(id).subscribe((res) => {
        console.log(res)
        alert('Customer deleted successfully');
        window.location.reload();       
      })
    }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  postCustomer(data:any):Observable<any>{
    return this.http.post<any>('http://localhost:8080/api/customer',data);
  }

  getAllCustomer():Observable<any>{
    return this.http.get<any>('http://localhost:8080/api/customers');
  }

  getCustomerById(id:number):Observable<any>{
    return this.http.get<any>('http://localhost:8080/api/customer/'+id);
  }

  updateCustomer(id:number,customer:any):Observable<any>{
    return this.http.put<any>('http://localhost:8080/api/customer/'+id,customer);
  };

  deleteCustomer(id:number):Observable<any>{
    return this.http.delete<any>('http://localhost:8080/api/customer/'+id);
  }
}

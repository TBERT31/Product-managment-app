import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getProduct(id:number): Observable<any>{
    return this.http.get(this.baseUrl+'/products/'+id);
  }

  createProduct(product: Object):Observable<Object>{
    return this.http.post(this.baseUrl+'/products/', product);
  }

  updateProduct(id:number, product: Object):Observable<Object>{
    return this.http.put(this.baseUrl+'/products/'+id, product);
  }

  deleteProduct(id:number):Observable<any>{
    return this.http.delete(this.baseUrl+'/products/'+id);
  }

  getProductsList():Observable<Object>{
    return this.http.get(this.baseUrl+'/products/');
  }
}

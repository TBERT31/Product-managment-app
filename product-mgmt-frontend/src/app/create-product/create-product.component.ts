import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { Product } from '../product';


@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  constructor(private productService: ProductService, private router: Router) { }

  product: Product = new Product();

  ngOnInit() {
  }

  saveProduct() {
    this.productService.createProduct(this.product)
      .subscribe(data => console.log(data), error => console.log(error));
    this.product = new Product();
    this.gotoProductList();
  }

  onSubmit() {
    this.saveProduct();    
  }

  gotoProductList() {
    this.router.navigate(['/products']);
  }

}

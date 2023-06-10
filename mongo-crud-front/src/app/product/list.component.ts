import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
import { Toast, ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit{
  products:Product[]=[];
  constructor(
    private productService:ProductService,
    private toast:ToastrService
  ){}
  ngOnInit(): void {
      this.getProducts();
  }
  getProducts():void{
    this.productService.list().subscribe(
      data=>{
        this.products=data;
        console.log(this.products);
      },
      err=>{
        this.toast.error(err.error.message,'Error',{timeOut:3000,positionClass:'toast-top-center'});
      }
    );
  }
}

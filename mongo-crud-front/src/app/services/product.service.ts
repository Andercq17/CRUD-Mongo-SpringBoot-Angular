import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productURL=environment.apiResrURL + '/product';
  constructor(private httpClient:HttpClient) { }

  //Wit this we get the list getAll
  public list():Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.productURL);
  }
}

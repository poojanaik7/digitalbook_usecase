import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  BASE_URL = "http://localhost:8085/api/digitalbooks/author/12/"

  URL="http://localhost:8085/api/digitalbooks/reader/search"

  constructor(private http:HttpClient) { }

  saveBook(book: { response:{title: string;author:string;publisher:string;category:string;releaseDate:Date;price:Number;active:boolean;content:string} }) {
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.post(this.BASE_URL+'books', book, {
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }

  searchBook(title: string,author:string,publisher:string,releaseDate:Date){
   let params = new HttpParams();
   params = params.append("title",title),
   params = params.append("author",author),
   params = params.append("publisher",publisher)
  //  params.append("releaseDate",releaseDate)
  return this.http.get(this.URL,{params})
    
  }
}

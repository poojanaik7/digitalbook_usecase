import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.css']
})
export class BookformComponent implements OnInit {

  book = {
    response :{
      title:"",
      author:"",
      publisher:"",
      category:"",
      releaseDate: new Date(),
      price:0,
      active:true,
      content:""
  }
  }
  constructor(private bookService : BookService) { }
  save(){
    console.log('saved');
    const observable= this.bookService.saveBook(this.book);
    observable.subscribe(response=>{
      console.log(response);

    })
  }

  ngOnInit(): void {
  }

}

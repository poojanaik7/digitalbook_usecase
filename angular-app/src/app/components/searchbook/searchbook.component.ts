import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.css']
})
export class SearchbookComponent implements OnInit {

  bookList : Array<any> = [];
  constructor() {
    if(history.state.bookList){
      this.bookList = history.state.bookList;
    }
   }

  ngOnInit(): void {
  }

}

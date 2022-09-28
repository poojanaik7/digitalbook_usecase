import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private bookService: BookService,private router: Router) { }

  b = {
    title: "Java",
    author: "pnaik",
    publisher: "xyz",

    releaseDate: new Date()
  }


  ngOnInit(): void {
  }

  searchBook() {
    const observable: Observable<any> = this.bookService.searchBook(this.b.title, this.b.author, this.b.publisher, this.b.releaseDate);
    observable.subscribe((response: any) => {
      let navigationExtras : NavigationExtras = {
        state:{
          bookList : response
        }
      };
      this.router.navigate(['bookList'],navigationExtras);
    },
      error => {
        alert("something went wrong"+error)
      }
    )
  }

}

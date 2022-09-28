import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  user = {
    firstname: "",
    lastname: "",
    email: ""
  }

  res: string = "";

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  save() {
    // console.log(this.fname);
    // console.log(this.lname);
    // console.log(this.email);     

    const observable = this.userService.createUser(this.user);
    observable.subscribe((response: any) => {
      this.res = response;
      return response;
    },
      function (error) {
        alert("Something went wrong please try again")
      }
    )
    }

}

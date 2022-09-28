import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user = {
    username:"",
    password:"",
    email:""
  }

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  register(){
    const observable : Observable<any> = this.userService.registerUser(this.user);
    observable.subscribe((response:any) => {
      console.log(response)
    },
    error =>{
      alert("something went wrong")
    }
    )
  }

}

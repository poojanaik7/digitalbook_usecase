import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  URL = "http://localhost:5000/users";

  BASE_URL = "http://localhost:8085/api/digitalbooks/auth/"

  createUser(user:{firstname: string,lastname: string, email: string}){
     return this.http.post(this.URL,user)
  }

  registerUser(user:{username: string,password: string,email: string}){
    return this.http.post(this.BASE_URL+"signup",user)
  }

  signinUser(user:{username: string,password: string}){
    return this.http.post(this.BASE_URL+"signin",user)
  }

  constructor(private http:HttpClient) { }
}

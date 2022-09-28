import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FormComponent } from './components/form/form.component';
import { SignupComponent } from './components/signup/signup.component';
import { SigninComponent } from './components/signin/signin.component';
import { SearchComponent } from './components/search/search.component';
import { Route, RouterModule } from '@angular/router';
import { BookformComponent } from './components/bookform/bookform.component';
import { SearchbookComponent } from './components/searchbook/searchbook.component';

const routes:Route []= [
  {path:'search', component:SearchComponent},
  {path:'signup',component:SignupComponent},
  {path:'signin',component:SigninComponent},
  {path:'',component:BookformComponent},
  {path:'searchdata',component:SearchbookComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FormComponent,
    SignupComponent,
    SigninComponent,
    SearchComponent,
    BookformComponent,
    SearchbookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

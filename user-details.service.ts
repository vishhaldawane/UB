import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserDetails } from './user-details';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserDetailsService {
//i need the object of HttpService class
  constructor(private myHttp: HttpClient) { }

  getAllUsers() : Observable<UserDetails[]> {
    //https://jsonplaceholder.typicode.com/users
    return this.myHttp.get<UserDetails[]>("https://jsonplaceholder.typicode.com/users");                                     // above url can be of REST API from spring boot app                                     //http://ocalhost:8080/UserApp/allUsers
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDetails } from './user-details';

@Injectable({
  providedIn: 'root'
})
export class UserDetailsService {

  constructor(private myHTTP: HttpClient) { }
  baseURL='http://localhost:8080/userdetails';

  loadAllUserDetailsService() : Observable<UserDetails[]> {
    return this.myHTTP.get<UserDetails[]>(this.baseURL+"/users");
  }

}

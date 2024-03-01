import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDetails } from './user-details';
import { response } from 'express';
import { text } from 'stream/consumers';

@Injectable({
  providedIn: 'root'
})
export class UserDetailsService {

  constructor(private myHTTP: HttpClient) { }
  baseURL='http://localhost:8080/userdetails';

  loadAllUserDetailsService() : Observable<UserDetails[]> {
    return this.myHTTP.get<UserDetails[]>(this.baseURL+"/users");
  }

  HTTPOptionsForText: Object = {
    headers: new HttpHeaders({'Content-Type': 'application/json'}),
    responseType: 'text'
 }
 
  deleteUserDetailsService(num:number) : Observable<any> {
    return this.myHTTP.delete<any>(this.baseURL+"/deleteUser/"+num, this.HTTPOptionsForText);
  }

  addUserDetailsService(newUserObj:UserDetails) : Observable<any> {
    return this.myHTTP.post<any>(this.baseURL+"/addUser",newUserObj, this.HTTPOptionsForText);
  }
}

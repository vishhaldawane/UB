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
    return this.myHttp.get<UserDetails[]>("http://localhost:3000/users");
    //return this.myHttp.get<UserDetails[]>("https://jsonplaceholder.typicode.com/users");                                     
    //http://ocalhost:8080/UserApp/allUsers
  }
  addUser(user:UserDetails): Observable<any> {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(user);
    console.log(body)
    return this.myHttp.post("http://localhost:3000/users",
     body,{'headers':headers})
  }
  updateUser(user:UserDetails): Observable<any> {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(user);
    console.log(body)
    return this.myHttp.put("http://localhost:3000/users",body,{'headers':headers})
  }
  getSingleUser(userIdToFind:number): Observable<any> {
     return this.myHttp.get("http://localhost:3000/users/"+userIdToFind);
   }

  deleteUser(userIdToDelete:string): Observable<any> {
    return this.myHttp.delete("http://localhost:3000/users/"+userIdToDelete);
  }
}

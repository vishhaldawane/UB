import { Component } from '@angular/core';
import { UserDetailsService } from '../user-details.service';
import { UserDetails } from '../user-details';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-user-demo',
  standalone: true,
  imports: [FormsModule,CommonModule, HttpClientModule],
  templateUrl: './user-demo.component.html',
  styleUrl: './user-demo.component.css'
})
export class UserDemoComponent {
  allUsers!: UserDetails[]; //an empty array
  constructor(private uds: UserDetailsService) {}
  showAllUsers() {
      this.uds.getAllUsers().subscribe(
        (data: UserDetails[]) => 
          {
            this.allUsers = data; // populate the data into local array
            console.log(this.allUsers);
          },
          (err)=> { console.log(err); }    
      );
  }

  newUser: UserDetails=new UserDetails(); //an empty array

  addUser() {
    this.uds.addUser(this.newUser)
      .subscribe(data => {
        console.log(data)
        //this.refreshUsers();
        this.showAllUsers();
      })      
  }

  refreshUsers() {
    this.uds.getAllUsers()
      .subscribe(data => {
        console.log(data)
        this.allUsers=data;
      })
  }
  num!: number;
  foundUser: UserDetails =  new  UserDetails();
  findSingleUser() {
    this.uds.getSingleUser(this.num).subscribe(
      (data: UserDetails) => 
        {
          this.foundUser = data; // populate the data into local user
          console.log(this.foundUser);
        },
        (err)=> { console.log(err); }    
    );
  }

  deleteIt(idToDelete:string) {
    this.uds.deleteUser(idToDelete).subscribe(
      (data: UserDetails) => 
        {
          //this.foundUser = data; // populate the data into local user
          console.log(this.foundUser);
          console.log('User deleted...');
          this.showAllUsers();
        },
        (err)=> { console.log(err); }    
    );
  }
}

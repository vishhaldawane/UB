import { Component } from '@angular/core';
import { UserDetails } from '../user-details';
import { UserDetailsService } from '../user-details.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view-all-user-details',
  standalone: true,
  imports: [HttpClientModule,
  FormsModule, CommonModule],
  templateUrl: './view-all-user-details.component.html',
  styleUrl: './view-all-user-details.component.css'
})
export class ViewAllUserDetailsComponent {
  allUserDetails!: UserDetails[];

  constructor(private userService: UserDetailsService) {

  }

  showAllUserDetails() {
    this.userService.loadAllUserDetailsService()
    .subscribe(
      (data: UserDetails[])=> {
        this.allUserDetails = data; //push the payload to local array
        console.log(this.allUserDetails);
      }, 
      (err) => {
        console.log(err);
      }
    );
  }

  msg!:string;
  deleteIt(id: number) {
    this.userService.deleteUserDetailsService(id)
    .subscribe({
      next: data => {
          this.msg = data;
          alert(this.msg);
          console.log(data);
          this.showAllUserDetails();
      },
      error: error => {
          alert(error.message);  //console.log(error);
          //this.msg = error.message;
          console.error('There was an error!', error.message);
      }
   
  });
  }

  newUser: UserDetails = new UserDetails();
  addIt() {
    this.userService.addUserDetailsService(this.newUser)
    .subscribe({
      next: data => {
          this.msg = data;
          alert(this.msg);
          console.log(data);
          this.showAllUserDetails();
      },
      error: error => {
          alert(error.message);  //console.log(error);
          //this.msg = error.message;
          console.error('There was an error!', error.message);
      }
   
  });
  }

  existingUser: UserDetails = new UserDetails();
  editIt() {
    this.userService.editUserDetailsService(this.existingUser)
    .subscribe({
      next: data => {
          this.msg = data;
          alert(this.msg);
          console.log(data);
          this.showAllUserDetails();
      },
      error: error => {
          alert(error.message);  //console.log(error);
          //this.msg = error.message;
          console.error('There was an error!', error.message);
      }
   
  });
  }
}


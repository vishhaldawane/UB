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
}


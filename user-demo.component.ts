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
}

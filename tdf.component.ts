import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-tdf',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './tdf.component.html',
  styleUrl: './tdf.component.css'
})
export class TdfComponent implements OnInit {

  title = 'Template driven forms';
  contact!: Contact;
  ngOnInit() {
    this.contact = {
      firstname: '',
      lastname: '',
      email:'', 
      gender: '', 
      isMarried: false,
      country:'' 
    };
  }
  countryList:country[] = [
    new country("1", "India"),
    new country('2', 'USA'),
    new country('3', 'England')
  ];

  onSubmit(contactForm: { value: any; }) {
    console.log(contactForm.value);
  }
}
export class Contact {
  firstname!:string;
  lastname!:string;
  email!: string;
  gender!:string;
  isMarried!:boolean;
  country!:string;
}

export class country {
  id:string;
  name:string;
 
  constructor(id:string, name:string) {
    this.id=id;
    this.name=name;
  }
}
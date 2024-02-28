import { Component } from '@angular/core';
import { CoursesService } from '../Services/courses.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-courses',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './courses.component.html',
  styleUrl: './courses.component.css'
})
export class CoursesComponent {
  constructor(private coursesService: CoursesService) { }

  //  courses = [];
    crs: any[]=[]; //is referred by the html file of this component
  
  
    ngOnInit(): void {
      this.crs = this.coursesService.courses;//let the original service's class array to be fetched
    }
}

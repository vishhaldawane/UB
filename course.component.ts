import { Component } from '@angular/core';
import { CoursesService } from '../../Services/courses.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-course',
  standalone: true,
  imports: [],
  templateUrl: './course.component.html',
  styleUrl: './course.component.css'
})
export class CourseComponent {
  constructor(private service: CoursesService, private route: ActivatedRoute) { }

  course: any;
  courseId!: number;

  ngOnInit(): void {
    this.courseId = this.route.snapshot.params['id'];
    //this.courseId = this.route.snapshot.params['name'];
    this.course = this.service.courses.find((x:any) => x.id == this.courseId);
  }
}

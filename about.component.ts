import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [],
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent implements OnInit
{
  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  GoToHome(){
    console.log('routing to the Home');
    this.router.navigate(['/Home'], {relativeTo: this.route}) //localhost:4200/About/Home
  }
}

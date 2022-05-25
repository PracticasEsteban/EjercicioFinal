import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-user-description',
  templateUrl: './user-description.component.html',
  styleUrls: ['./user-description.component.css']
})
export class UserDescriptionComponent implements OnInit {

  @Input() text:string;
  constructor() { }

  ngOnInit(): void {
  }

}

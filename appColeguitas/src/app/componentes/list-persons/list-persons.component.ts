import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-list-persons',
  templateUrl: './list-persons.component.html',
  styleUrls: ['./list-persons.component.css']
})
export class ListPersonsComponent implements OnInit {

 @Input() arrayUser:any;
 @Output() sendUser:EventEmitter<User>=new EventEmitter;

  constructor() { }

  ngOnInit(): void {
  }

  onClickFriend(item:User){

    console.log(item)
this.sendUser.emit(item)
  }

}

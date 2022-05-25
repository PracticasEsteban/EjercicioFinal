import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-search-friend',
  templateUrl: './search-friend.component.html',
  styleUrls: ['./search-friend.component.css']
})
export class SearchFriendComponent implements OnInit {

  textName:string;

  @Output() sendName = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
    
  }

  searchName(){
    this.sendName.emit(this.textName);
  }

}

import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { ApiService } from '../api.service';
import { Historieta } from '../models/historieta.model';
import {Friend} from '../models/friend.model';

@Component({
  selector: 'app-page-mis-cosas',
  templateUrl: './page-mis-cosas.component.html',
  styleUrls: ['./page-mis-cosas.component.css']
})
export class PageMisCosasComponent implements OnInit {

  constructor(private api:ApiService) { }
  user:any;
  arrayPosts:any;
  arrayFriends:any;



  ngOnInit(): void {

    let jsonObjectUser: any= JSON.parse(JSON.stringify(localStorage.getItem("user")));
    this.user= <User> JSON.parse(jsonObjectUser);

   
    this.getPosts("ok");
   this.getFriends("ok");

  }

  getFriends(event:any){
    this.api.getFriendsAccept(this.user.id).subscribe((data:any)=>{
      this.arrayFriends=<User> data;
    })
  }

  getPosts(event:any){
    this.api.getPostPersonAndUser(this.user.id).subscribe((data:any)=>{
      this.arrayPosts=<Historieta> data;
    })
  }

}

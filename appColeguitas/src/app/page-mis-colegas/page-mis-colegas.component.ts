import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-page-mis-colegas',
  templateUrl: './page-mis-colegas.component.html',
  styleUrls: ['./page-mis-colegas.component.css']
})
export class PageMisColegasComponent implements OnInit {

  arrayUser:any;
  user:any;
  userFriend:any;

  constructor(private api:ApiService) { }

  ngOnInit(): void {

    let jsonObjectUser: any= JSON.parse(JSON.stringify(localStorage.getItem("user")));
    this.user= <User> JSON.parse(jsonObjectUser);

    this.api.getPersons().subscribe((data:any)=>{
      this.arrayUser=<User> data;
      this.arrayUser.splice(0,1)
    })
  }


  getByName(event:string){
    
    this.api.getPersonByName(event).subscribe((data:any)=>{
      this.arrayUser=<User> data;
    })
  }

  sendUser(friend:User){
 
    this.userFriend=friend;
  }

}

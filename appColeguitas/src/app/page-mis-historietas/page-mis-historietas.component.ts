import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-page-mis-historietas',
  templateUrl: './page-mis-historietas.component.html',
  styleUrls: ['./page-mis-historietas.component.css']
})
export class PageMisHistorietasComponent implements OnInit {

  constructor(private api:ApiService) { }

  arrayHistorietas:any;
  user:any;

  ngOnInit(): void {

    let jsonObjectUser: any= JSON.parse(JSON.stringify(localStorage.getItem("user")));
    this.user= <User> JSON.parse(jsonObjectUser);

    this.getHistorietas("Go");
  }

  getHistorietas(event:any){

    this.api.getPostsUser(this.user.id).subscribe((data:any)=>{

      this.arrayHistorietas=data;
    });

  }

}

import { Component, OnInit } from '@angular/core';
import { User } from './models/user.model';
import { ApiService } from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
 
  title = 'appColeguitas';

  constructor(public api:ApiService) {}

  ngOnInit(): void {
    
    //Guaramos User En local Storage

    this.api.getPersonById(1).subscribe((userJson:any) =>{

        localStorage.setItem("user",JSON.stringify(userJson));
       
    }
    );
  }
}

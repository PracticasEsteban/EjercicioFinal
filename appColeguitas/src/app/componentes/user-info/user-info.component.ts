import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import swal from 'sweetalert2';
import { ApiService } from 'src/app/api.service';
import { AnyForUntypedForms } from '@angular/forms';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  user:any;
  newUser: Partial<User> ={};


  constructor(private api:ApiService) { }

  ngOnInit(): void {

    let jsonObjectUser: any= JSON.parse(JSON.stringify(localStorage.getItem("user")));
    this.user= <User> JSON.parse(jsonObjectUser);

    console.log(jsonObjectUser);
  }

   openUpdate(){

let name:any;


swal.fire({
  title: 'Actualizar nombre Usuario',
  input: 'text',
  inputLabel:'Nombre:',
  inputPlaceholder:this.user.name,
  showCancelButton: true        
}).then((result) => {
  if (result.value) {
      this.user.name = result.value;

      
  }
});

this.api.putPerson(this.user).subscribe((data:any)=>{
  localStorage.setItem("user",JSON.stringify(data));
  
})
  }

}

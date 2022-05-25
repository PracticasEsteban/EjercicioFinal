import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Historieta } from 'src/app/models/historieta.model';
import { User } from 'src/app/models/user.model';
import { ApiService } from 'src/app/api.service';
import swal from 'sweetalert2'


@Component({
  selector: 'app-post-historieta',
  templateUrl: './post-historieta.component.html',
  styleUrls: ['./post-historieta.component.css']
})
export class PostHistorietaComponent implements OnInit {

  textArea:any;
  user:any;

  @Output() sendPost = new EventEmitter<string>();
  

  constructor(private api:ApiService) { }

  ngOnInit(): void {

    let jsonObjectUser: any= JSON.parse(JSON.stringify(localStorage.getItem("user")));
    this.user= <User> JSON.parse(jsonObjectUser);
  }

  onSubmit():void{
    if(this.textArea==undefined){

      this.textArea=window.prompt("Escribe la historieta");
    }

    let historieta: Partial<Historieta> ={};
    historieta.user= new User(this.user.id,this.user.name,this.user.surnames,this.user.email,this.user.description,this.user.image,this.user.date);
    historieta.text=this.textArea;
    
    let dateObj = new Date();
    let month = dateObj.getUTCMonth() + 1; 
    let day = dateObj.getUTCDate();
    let year = dateObj.getUTCFullYear();
    let newdate;
    if(month<=9){
        let monthString = "0"+month.toString();
        newdate = year + "-" + monthString + "-" + day;

    }else{
      newdate = year + "-" + month + "-" + day;
    }
 

    historieta.date= newdate;

    console.log(JSON.stringify(historieta))

    this.api.postPost(historieta).subscribe((historietawithId:any)=>{
      
    swal.fire({
      title: 'Historieta Subida con Exito!',
      text: 'Quieres continuar?',
      icon: 'success',
      confirmButtonText: 'Cool'
    })
      this.sendPost.emit("Go")
    });
    

  
  }

}

import { Component, Input, OnInit, OnChanges, SimpleChanges, SimpleChange } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { ApiService } from 'src/app/api.service';
import { Friend } from 'src/app/models/friend.model';
import swal from 'sweetalert2';


@Component({
  selector: 'app-friend-info',
  templateUrl: './friend-info.component.html',
  styleUrls: ['./friend-info.component.css']
})
export class FriendInfoComponent implements OnInit, OnChanges {

 @Input() userFriend:User;
 @Input() user:User;
 friendRelation:any;

  constructor(private api:ApiService) { }


  ngOnChanges(changes: SimpleChanges): void {
    if(this.userFriend!=undefined){

      this.api.getRelationFriendIfExist(this.user.id,this.userFriend.id).subscribe((data:any)=>{

        this.friendRelation=data;
      },(error)=>{
        console.log("No")
        this.friendRelation=false;
      })
      

    }
  }

  addFriend(){

    let relationFriend : Partial<Friend> ={};
    relationFriend.userSend=this.user;
    relationFriend.userRecive=this.userFriend;
    
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
 
    relationFriend.date=newdate;

    relationFriend.accept=false;

    this.api.addRelation(relationFriend).subscribe((data:any)=>{
      swal.fire({
        title: 'Amigo Añadido con Exito!',
        text: 'Quieres continuar?',
        icon: 'success',
        confirmButtonText: 'Cool'
      })
  
      this.ngOnChanges(this.friendRelation);
    })
    
  }
  deleteFriend(){

    swal.fire({
      title: 'Quieres eliminar el amigo '+this.userFriend.name+"?",
      text: "No vas a poder rebertir el cambio!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminala!'
    }).then((result) => {
      if (result.isConfirmed) {

        this.api.deleteRelation(this.friendRelation.id).subscribe((data:any)=>{
          swal.fire(
            'Eliminado!',
            'El amigo  ha sido eliminado.',
            'success'
          )
        this.ngOnChanges(this.friendRelation);

        })

      
       
      }
    })
    
  }

  ngOnInit(): void {
   
  }

}

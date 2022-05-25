import { Component, OnInit , Input, Output, EventEmitter} from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { Friend } from 'src/app/models/friend.model';
import swal from 'sweetalert2';


@Component({
  selector: 'app-list-friends',
  templateUrl: './list-friends.component.html',
  styleUrls: ['./list-friends.component.css']
})
export class ListFriendsComponent implements OnInit {

  @Input() user:any;
  
  @Input() arrayFriends:any;

  @Output() changeFriend = new EventEmitter<string>();

  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  onClickFriend(friend:any){

    swal.fire({
      title: 'Quieres eliminar el amigo '+friend.name+"?",
      text: "No vas a poder rebertir el cambio!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminala!'
    }).then((result) => {
      if (result.isConfirmed) {

       this.api.getRelationFriendIfExist(this.user.id,friend.id).subscribe((data:any)=>{

        let friendRelation = <Friend> data;

        this.api.deleteRelation(friendRelation.id).subscribe((data:any)=>{
          swal.fire(
            'Eliminado!',
            'El amigo  ha sido eliminado.',
            'success'
          )
          this.changeFriend.emit("Go");

        })

       })
       
      }
    })

  }

}

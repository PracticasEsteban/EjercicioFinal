import { Component, Input, OnInit , OnChanges, SimpleChanges, Output, EventEmitter} from '@angular/core';
import swal from 'sweetalert2'
import { ApiService } from 'src/app/api.service';
import { User } from 'src/app/models/user.model';




@Component({
  selector: 'app-list-historietas',
  templateUrl: './list-historietas.component.html',
  styleUrls: ['./list-historietas.component.css'],
  
})
export class ListHistorietasComponent implements OnInit, OnChanges {

  
 @Input() user:User;
 @Input() arrayPosts:any;

 @Output() sendPost = new EventEmitter<string>();

  constructor(private api:ApiService) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.arrayPosts = this.arrayPosts.reverse();
  }

  ngOnInit(): void {

    
  }

  openModal(item:any):void{

    if(item.user.id==this.user.id){

      
    swal.fire({
      title: 'Quieres eliminar la historia? '+item.id,
      text: "No vas a poder rebertir el cambio!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminala!'
    }).then((result) => {
      if (result.isConfirmed) {

        this.api.deletePostId(item).subscribe((data:any)=>{
          swal.fire(
            'Eliminada!',
            'La historieta ha sido eliminada.',
            'success'
          )

          this.sendPost.emit("Go");
        })
       
      }
    })


    }


  }

}

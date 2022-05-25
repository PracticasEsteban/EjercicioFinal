import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './models/user.model';
import { Historieta } from './models/historieta.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }

  url:string = "http://localhost:9000/api";


  //Get All users
  getPersons(){
    return this.http.get(this.url+"/person")
  }

  //Get Person with id
  getPersonById(id:number){
    return this.http.get(this.url+"/person/"+id)
  }

  //Get Person por nombre
  getPersonByName(name:string){
    return this.http.get(this.url+"/person?search=user.name:"+name)
  }

  //Get Person por email
  getPersonByEmail(email:string){
    return this.http.get(this.url+"/person?search=user.email:"+email)
  }

  //Post Person
  postPerson(person:User){
    return this.http.post(this.url+"/person", person)
  }

  //Put Person
  putPerson(person:any){
    return this.http.put(this.url+"/person/"+person.id, person)
  }

  //Delete Person
  deletePerson(person:User){
    return this.http.delete(this.url+"/person/"+person.id);

  }

  //AddHistorieta
//Post Person
  postPost(historieta:any){
  return this.http.post(this.url+"/post", historieta)
  }

  //GetPostUserID

  getPostsUser(id:any){

    return this.http.get(this.url+"/post?search=user.id:"+id)
   
  }

  //Delete Post

  deletePostId(item:any){
    return this.http.delete(this.url+"/post/"+item.id, item )
  }

  //Get post amigos

  getPostPersonAndUser(id:number){
    return this.http.get(this.url+"/post/person/"+id)
  }

  //Get Friends Acceptadas

  getFriendsAccept(id:number){
    return this.http.get(this.url+"/friend/accept/"+id)
  }

  //Get Friends send no accept

  getFriendsSendNoAccept(id:number){
    return this.http.get(this.url+"/friend/send/"+id)
  }
  //Get Friend recive no accept
  getFriendsReciveNoAccept(id:number){
    return this.http.get(this.url+"/friend/recive/"+id)
  }

  //Get RelationFriend if exist

  getRelationFriendIfExist(id1:number, id2:number){
    return this.http.get(this.url+"/friend/user/"+id1+"/friend/"+id2)
    
  }
  //Delete Relation
  deleteRelation(id:number){
    return this.http.delete(this.url+"/friend/"+id)
  }

//Add Relation

addRelation(friend:any){
  return this.http.post(this.url+"/friend",friend);
}


}

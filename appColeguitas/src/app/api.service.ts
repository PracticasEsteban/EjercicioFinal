import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './models/user.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }

  url:string = "localhost:9000/api";


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
    return this.http.post(this.url+"/person", JSON.stringify(person))
  }

  //Put Person
  putPerson(person:User){
    return this.http.put(this.url+"/person/"+person.id, JSON.stringify(person))
  }

  //Delete Person
  deletePerson(person:User){

  }






}

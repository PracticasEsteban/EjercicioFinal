import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

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






}

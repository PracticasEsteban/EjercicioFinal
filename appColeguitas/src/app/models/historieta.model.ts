import {User} from "./user.model"

export class Historieta{
    constructor(
        public id:number,
        public user:User,
        public text:string,
        public date:Date
    ){}
}
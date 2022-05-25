import { User } from "./user.model";
export class Friend{
    constructor(
        public id:number,
        public userSend:User,
        public userRecive:User,
        public accept:Boolean,
        public date:string
    ){}
}
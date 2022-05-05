import { Historieta } from "./historieta.model";
import { User } from "./user.model";

export class HistorietaEstado{
    constructor(
        public id:number,
        public historieta:Historieta,
        public estado:string,
        public user:User,
        public date:Date
    ){}
}
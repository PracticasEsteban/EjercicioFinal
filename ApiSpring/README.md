# SPRING BOOT API REST


### **INFO**
  
     SpringBoot con una BD MYSQL , la BD se monta e insertan los datos cada vez que se ejecuta, los archivos se encuentran /src/main/resources . data.sql y schema.sql  (schema crea tablas y data inserta datos).
     Puerto: 9000
     Path: api
     Ejemplo: localhost:9000/api/post
     
     
### **PETICIONES REST**

      Filtrados hechos por variable search=user.name:Ejemplo,user.surnames;Ejemplo (entidad, atributo, condicion, valor). Filtrado por campos del modelo a utilizar. Las relaciones sql estan hechas por los modelos y jpa (Se obtiene objeto cporel id no el id),
      
      Condición Carácter : (LIKE)
      Condición Carácter ; (=)

#### REST person TABLA USER 

      [GET]  localhost:9000/api/person/count -> Get numero total de Usuarios
      [GET]  localhost:9000/api/person  -> Get All users
      [GET]  localhost:9000/api/person/1 -> Get Usuario id 1 
      [GET]  localhost:9000/api/person?search=user.name:Esteban ->Obtenemos user por nombre (name, surnames, email)
      [POST] localhost:9000/api/person -> +JSON User , add user
      [PUT]  localhost:9000/api/person/1 -> +JSON USer , edit user id 1
      [DELETE]  localhost:9000/api/person/1 -> +JSON USer , delete user id 1
      
      
#### REST post TABLA HISTORIETA

      [GET]  localhost:9000/api/post/count -> Get numero total de Historietas
      [GET]  localhost:9000/api/post  -> Get All Historietas
      [GET]  localhost:9000/api/post/1 -> Get Historieta id 1 
      [GET]  localhost:9000/api/post?search=user.id:1 ->Obtenemos historietas del usuario id 1 (id, name, surnames, email)
      [GET]  localhost:9000/api/post/person/1 -> Obtenemos historietas user id 1 más historietas de sus amigos 
      [POST] localhost:9000/api/post -> +JSON Historieta , add historieta
      [PUT]  localhost:9000/api/post/1 -> +JSON Historieta , edit historieta id 1
      [DELETE]  localhost:9000/api/post/1 -> +JSON Historieta , delete historieta id 1  
      
      
#### REST postState TABLA HISTORIETA_ESTADO

      [GET]  localhost:9000/api/postState/count -> Get numero total de estados de historietas
      [GET]  localhost:9000/api/postState  -> Get All Estados de historieta
      [GET]  localhost:9000/api/postState/1 -> Get Historieta Estado id 1 
      [GET]  localhost:9000/api/postState?search=user.id:1 ->Obtenemos historietas estados del usuario id 1 (historieta.id, user.id, user.name etc)
      [POST] localhost:9000/api/postState -> +JSON Historieta_Estado , add historieta_estado
      [PUT]  localhost:9000/api/postState/1 -> +JSON Historieta_Estado , edit historieta_estado id 1
      [DELETE]  localhost:9000/api/postState/1 -> +JSON Historieta_Estado , delete historieta_estado id 1       
      
 #### REST friend TABLA Friend

      [GET]  localhost:9000/api/friend/count -> Get numero total de Amigos
      [GET]  localhost:9000/api/friend  -> Get All friends
      [GET]  localhost:9000/api/friend/1 -> Get friend relation id 1 
      [GET]  localhost:9000/api/friend/user/1/friend/2 -> Get relation if exist user id 1 mas user id 2 
      [GET]  localhost:9000/api/friend/recive/1  -> Get All invitaciones de amistat recividas del usuario 1 no aceptadas.
      [GET]  localhost:9000/api/friend/send/1  -> Get All invitaciones de amistat enviadas del usuario 1 no aceptadas por los otros usuarios.
      [GET]  localhost:9000/api/friend/accept/1  -> Get todos los amigos del usuario 1 (Info imagen, name , fecha etc, No info sensible).
      [GET]  localhost:9000/api/friend?search=friend.accpet ->Obtenemos todas las relaciones aceptadas (friend.accept ,friend.date, userSend.id, userSend.name, userRecive.id, userRecive.name etc )
      [POST] localhost:9000/api/friend -> +JSON Friend , add friend
      [PUT]  localhost:9000/api/friend/1 -> +JSON friend , edit friend id 1
      [DELETE]  localhost:9000/api/friend/1 -> +JSON friend , delete friend id 1       
           
      
      

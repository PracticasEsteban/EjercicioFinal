# SPRING BOOT API REST


### **INFO**
  
     SpringBoot con una BD MYSQL , la BD se monta e insertan los datos cada vez que se ejecuta, los archivos se encuentran /src/main/resources . data.sql y schema.sql  (schema crea tablas y data inserta datos).
     Puerto: 9000
     Path: api
     Ejemplo: localhost:9000/api/post
     
     
### **PETICIONES REST**

      Filtrados hechos por variable search=user.name:Ejemplo,user.surnames;Ejemplo. Filtrado por campos del modelo a utilizar
      
      Caracter : (LIKE)
      Caracter ; (=)

#### REST person TABLA USER 

      [GET]  localhost:9000/api/person/count -> Get numero total de Uuuarios
      [GET]  localhost:9000/api/person  -> Get All users
      [GET]  localhost:9000/api/person/1 -> Get Usuario id 1 
      [GET]  localhost:9000/api/person?search=user.name:Esteban ->Obtenemos user por nombre (name, surnames, email)
      [POST] localhost:9000/api/person -> +JSON User , add user
      [PUT]  localhost:9000/api/person/1 -> +JSON USer , edit user id 1
      [DELETE]  localhost:9000/api/person/1 -> +JSON USer , delete user id 1
      
      

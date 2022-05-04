package nttdata.esteban.ApiSpring.rest.service;


import nttdata.esteban.ApiSpring.repository.customJPADAO.IFriendCustomJPADAO;
import nttdata.esteban.ApiSpring.repository.jpa.IFriendJPADAO;
import nttdata.esteban.ApiSpring.repository.modelo.Friend;

import nttdata.esteban.ApiSpring.repository.modelo.User;
import nttdata.esteban.ApiSpring.rest.dto.FriendDTO;

import nttdata.esteban.ApiSpring.rest.dto.UserDTO;
import nttdata.esteban.ApiSpring.rest.mapper.FriendMapper;

import nttdata.esteban.ApiSpring.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FriendService {

    @Autowired
    IFriendJPADAO iFriendJPADAO;


    @Autowired
    IFriendCustomJPADAO iFriendCustomJPADAO;


    public Long count(){return this.iFriendJPADAO.count();}



    public List<FriendDTO> findAll(Boolean conTodo, String search){

        List<Friend> friends= new ArrayList<>();

        if (search.equalsIgnoreCase("false")){
           friends = this.iFriendJPADAO.findAll();
        }else{
            friends = this.iFriendCustomJPADAO.findAllWithSearch(search);
        }

        return FriendMapper.map(friends,conTodo);


    }

    public FriendDTO findById(Integer id, Boolean conTodo) {

        Optional<Friend> friend = this.iFriendJPADAO.findById(id);

        return FriendMapper.map(friend, conTodo);
    }

    public FriendDTO create(FriendDTO friendDTO) {

        Friend friend = FriendMapper.map(friendDTO, false);
        friend = this.iFriendJPADAO.save(friend);

        return FriendMapper.map(friend, false);
    }

    public void update(FriendDTO friendDTO) {

        Friend friend = FriendMapper.map(friendDTO,false);

        this.iFriendJPADAO.save(friend);

    }
    public void delete(FriendDTO friendDTO) {
        Friend friend = FriendMapper.map(friendDTO,false);

        this.iFriendJPADAO.delete(friend);
    }

    //Retornamos todas las solicitudes de amistat recividas no aceptadas
    public List<FriendDTO> findAllReciveNoAccept(Integer id) {

        List<Friend> amigosRecividoNoAceptado= new ArrayList<>();
        String friendReciveNoAccept="friend.accept:false,userRecive.id:"+id;

        amigosRecividoNoAceptado = this.iFriendCustomJPADAO.findAllWithSearch(friendReciveNoAccept);
        return FriendMapper.map(amigosRecividoNoAceptado,false);
    }

    //Retornamos todas las solicitudes de amistat enviadas no aceptadas
    public List<FriendDTO> findAllSendNoAccept(Integer id) {

        List<Friend> amigosEnviadoNoAceptado= new ArrayList<>();
        String friendSendNoAccept="friend.accept:false,userSend.id:"+id;

        amigosEnviadoNoAceptado = this.iFriendCustomJPADAO.findAllWithSearch(friendSendNoAccept);
        return FriendMapper.map(amigosEnviadoNoAceptado,false);
    }

    //Retornamos  todos los amigos Aceptados del usuario
    public List<UserDTO> findAllFriendAccept(Integer id) {

        List<User> listaAmigos= new ArrayList<>();
        //Amigos del usuario

        List<Friend> amigosEnviadoAceptado = new ArrayList<>();
        String friendSendAccept="friend.accept:true,userSend.id:"+id;

        List<Friend> amigosRecividoAceptado = new ArrayList<>();
        String friendRecividoAccept="friend.accept:true,userRecive.id:"+id;

        //Obtenemos los amigos
        amigosEnviadoAceptado = this.iFriendCustomJPADAO.findAllWithSearch(friendSendAccept);
        amigosRecividoAceptado=this.iFriendCustomJPADAO.findAllWithSearch(friendRecividoAccept);

        //Añadimos el Usuario de la relacion de amistat al Array
        for (Friend f:amigosEnviadoAceptado){

            listaAmigos.add(f.getUserRecive());
        }
        for (Friend f:amigosRecividoAceptado){

            listaAmigos.add(f.getUserSend());
        }
        return UserMapper.map(listaAmigos,false);
    }

    //Retornamos la relacion de usuario y amigo para poder hacer un put luego
    public FriendDTO findRelationFriend(Integer idUser, Integer idFriend) {

        //Primero obtenemos la relacion obtenida recivida
        List<Friend> amigo= new ArrayList<>();


        String friendReciveAccept="userRecive.id:"+idUser+",userSend.id:"+idFriend;

        amigo = this.iFriendCustomJPADAO.findAllWithSearch(friendReciveAccept);
        //Si esta vacio hacemos la consulta ala inversa
        if (amigo.isEmpty()||amigo==null){

            String friendSendAccept="userRecive.id:"+idFriend+",userSend.id:"+idUser;
            amigo = this.iFriendCustomJPADAO.findAllWithSearch(friendSendAccept);

            //Si esta vacio retornamos null Ya que no habria encontrado relacion entre los dos id
            if (amigo.isEmpty() || amigo == null) return null;
            else return FriendMapper.map(amigo.get(0),false);

        }else{//Sino retornamos relacion amistat obtenida
            return FriendMapper.map(amigo.get(0),false);
        }

    }

}

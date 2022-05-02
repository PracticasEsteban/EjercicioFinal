package nttdata.esteban.ApiSpring.rest.mapper;

import nttdata.esteban.ApiSpring.repository.modelo.Friend;
import nttdata.esteban.ApiSpring.rest.dto.FriendDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FriendMapper {

    //Traduce un objeto Friend(JPA) a FriendDTO
    public static FriendDTO map(Friend friend, boolean conTodo){
        if (friend == null) return null;

        FriendDTO friendDTO = new FriendDTO();

        friendDTO.setId(friend.getId());
        friendDTO.setUserRecive(UserMapper.map(friend.getUserRecive(),false));
        friendDTO.setUserSend(UserMapper.map(friend.getUserSend(),false));
        friendDTO.setDate(friend.getDate());
        friendDTO.setAccept(friend.getAccept());

        if (!conTodo) return friendDTO;

        //Añadimos mas adelante

        return friendDTO;
    }

    //Traduce Optional<Friend> a un FriendDTO
    public static FriendDTO map(Optional<Friend> friend, boolean conTodo){

        if (friend.isEmpty())return null;

        return FriendMapper.map(friend.get(),conTodo);

    }

    //Traduce una lista de FriendJPA a una lista de FriendDTO

    public static List<FriendDTO> map(List<Friend> friends, boolean conTodo){

        if (friends == null) return null;
        if (friends.isEmpty())return  null;

        return friends.stream().map(x -> FriendMapper.map(x,conTodo)).collect(Collectors.toList());

    }

    //Traduce un FriendDTO a un friendJPA

    public static Friend map(FriendDTO friendDTO, boolean conTodo) {

        if (friendDTO == null) return  null;

       Friend friend = new Friend();
       friend.setId(friendDTO.getId());
       friend.setUserRecive(UserMapper.map(friendDTO.getUserRecive(),false));
       friend.setUserSend(UserMapper.map(friendDTO.getUserSend(),false));
       friend.setDate(friendDTO.getDate());
       friend.setAccept(friendDTO.getAccept());

        if (!conTodo) return friend;

        //Add mas adelante

        return friend;
    }

}

package nttdata.esteban.ApiSpring.rest.mapper;

import nttdata.esteban.ApiSpring.repository.modelo.User;
import nttdata.esteban.ApiSpring.rest.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserMapper {

    //Traduce un objeto User(JPA) a UserDTO
    public static UserDTO map(User user, boolean conTodo){
        if (user == null) return null;

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurnames(user.getSurnames());
        userDTO.setEmail(user.getEmail());
        userDTO.setDescription(user.getDescription());
        userDTO.setImage(user.getImage());

        if (!conTodo) return userDTO;

        //Añadimos arrayList Friends

        return userDTO;
    }

    //Traduce Optional<User> a un UserDTO
    public static UserDTO map(Optional<User> user, boolean conTodo){

        if (user.isEmpty())return null;

        return UserMapper.map(user.get(),conTodo);

    }

    //Traduce una lista de UserJPA a una lista de UserDTO

    public static List<UserDTO> map(List<User> users, boolean conTodo){

        if (users == null) return null;
        if (users.isEmpty())return  null;

        return users.stream().map(x -> UserMapper.map(x,conTodo)).collect(Collectors.toList());

    }

    //Traduce un userDTO a un userJPA

    public static User map(UserDTO userDTO, boolean conTodo) {

        if (userDTO == null) return  null;

        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurnames(userDTO.getSurnames());
        user.setEmail(userDTO.getEmail());
        user.setDescription(userDTO.getDescription());
        user.setImage(userDTO.getImage());

        if (!conTodo) return user;

        //Añadir array list friends

        return user;
    }

}

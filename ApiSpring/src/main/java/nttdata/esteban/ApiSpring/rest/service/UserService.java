package nttdata.esteban.ApiSpring.rest.service;

import nttdata.esteban.ApiSpring.repository.jpa.IUserJPADAO;
import nttdata.esteban.ApiSpring.repository.modelo.User;
import nttdata.esteban.ApiSpring.rest.dto.UserDTO;
import nttdata.esteban.ApiSpring.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserJPADAO iUserJPADAO;

    public Long count(){return this.iUserJPADAO.count();}



    public List<UserDTO> findAll(Boolean conTodo, String search){

    List<User> users= new ArrayList<>();

    if (search.equalsIgnoreCase("false")){
        users = this.iUserJPADAO.findAll();
    }else{
        users = null;
    }

    return UserMapper.map(users,conTodo);


    }

    public UserDTO findById(Integer id, Boolean conTodo) {

        Optional<User> user = this.iUserJPADAO.findById(id);

        return UserMapper.map(user, conTodo);
    }

    public UserDTO create(UserDTO usersDTO) {

        User user = UserMapper.map(usersDTO, true);
        user = this.iUserJPADAO.save(user);

        return UserMapper.map(user, false);
    }

    public void update(UserDTO userDTO) {

        User user = UserMapper.map(userDTO, true);
        this.iUserJPADAO.save(user);

    }
    public void delete(UserDTO userDTO) {
        User user = UserMapper.map(userDTO, false);
        this.iUserJPADAO.delete(user);
    }


}

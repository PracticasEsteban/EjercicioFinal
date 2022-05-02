package nttdata.esteban.ApiSpring.rest.service;


import nttdata.esteban.ApiSpring.repository.jpa.IFriendJPADAO;
import nttdata.esteban.ApiSpring.repository.modelo.Friend;

import nttdata.esteban.ApiSpring.rest.dto.FriendDTO;

import nttdata.esteban.ApiSpring.rest.mapper.FriendMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FriendService {

    @Autowired
    IFriendJPADAO iFriendJPADAO;


    public Long count(){return this.iFriendJPADAO.count();}



    public List<FriendDTO> findAll(Boolean conTodo, String search){

        List<Friend> friends= new ArrayList<>();

        if (search.equalsIgnoreCase("false")){
           friends = this.iFriendJPADAO.findAll();
        }else{
            friends = null;
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

}

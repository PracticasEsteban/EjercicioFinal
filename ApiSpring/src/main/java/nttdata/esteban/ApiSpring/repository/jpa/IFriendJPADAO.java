package nttdata.esteban.ApiSpring.repository.jpa;

import nttdata.esteban.ApiSpring.repository.modelo.Friend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFriendJPADAO extends JpaRepository<Friend,Integer> {


    @Query("select f from Friend f join fetch f.userSend us join fetch f.userRecive fr")
    List<Friend> findAll();
}

package nttdata.esteban.ApiSpring.repository.jpa;

import nttdata.esteban.ApiSpring.repository.modelo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFriendJPADAO extends JpaRepository<Friend,Integer> {

}

package nttdata.esteban.ApiSpring.repository.customJPADAO;

import nttdata.esteban.ApiSpring.repository.modelo.Friend;

import java.util.List;

public interface IFriendCustomJPADAO {

    List<Friend> findAllWithSearch(String search);
}

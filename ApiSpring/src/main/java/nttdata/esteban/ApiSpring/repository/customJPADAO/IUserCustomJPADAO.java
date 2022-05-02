package nttdata.esteban.ApiSpring.repository.customJPADAO;

import nttdata.esteban.ApiSpring.repository.modelo.User;

import java.util.List;

public interface IUserCustomJPADAO {

    List<User> findAllWithSearch(String search);
}

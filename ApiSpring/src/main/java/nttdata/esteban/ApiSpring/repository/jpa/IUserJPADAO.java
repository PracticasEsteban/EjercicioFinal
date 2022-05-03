package nttdata.esteban.ApiSpring.repository.jpa;

import nttdata.esteban.ApiSpring.repository.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJPADAO extends JpaRepository<User, Integer> {
}

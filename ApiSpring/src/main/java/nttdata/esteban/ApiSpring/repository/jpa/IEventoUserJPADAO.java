package nttdata.esteban.ApiSpring.repository.jpa;

import nttdata.esteban.ApiSpring.repository.modelo.EventoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEventoUserJPADAO extends JpaRepository<EventoUser, Integer> {

    @Query("select ev from EventoUser ev join fetch ev.user u join fetch ev.evento e")
    List<EventoUser> findAll();
}

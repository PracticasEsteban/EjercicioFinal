package nttdata.esteban.ApiSpring.repository.jpa;

import nttdata.esteban.ApiSpring.repository.modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventoJPADAO extends JpaRepository<Evento,Integer> {
}

package nttdata.esteban.ApiSpring.repository.jpa;

import nttdata.esteban.ApiSpring.repository.modelo.Historieta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistorietaJPADAO extends JpaRepository<Historieta, Integer> {
}

package nttdata.esteban.ApiSpring.repository.jpa;

import nttdata.esteban.ApiSpring.repository.modelo.HistorietaEstado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistorietaEstadoJPADAO extends JpaRepository<HistorietaEstado, Integer> {
}

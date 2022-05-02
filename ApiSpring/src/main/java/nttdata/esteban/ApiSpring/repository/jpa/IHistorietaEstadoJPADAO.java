package nttdata.esteban.ApiSpring.repository.jpa;


import nttdata.esteban.ApiSpring.repository.modelo.HistorietaEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHistorietaEstadoJPADAO extends JpaRepository<HistorietaEstado, Integer> {

    @Query("select e from HistorietaEstado e join fetch e.user u join fetch e.historieta h")
    List<HistorietaEstado> findAll();
}

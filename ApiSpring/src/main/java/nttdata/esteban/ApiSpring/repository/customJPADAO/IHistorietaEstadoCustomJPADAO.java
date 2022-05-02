package nttdata.esteban.ApiSpring.repository.customJPADAO;

import nttdata.esteban.ApiSpring.repository.modelo.HistorietaEstado;

import java.util.List;

public interface IHistorietaEstadoCustomJPADAO {

    List<HistorietaEstado> findAllWithSearch(String search);
}

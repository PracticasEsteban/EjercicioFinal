package nttdata.esteban.ApiSpring.repository.customJPADAO;

import nttdata.esteban.ApiSpring.repository.modelo.Historieta;

import java.util.List;

public interface IHistorietaCustomJPADAO {

    //Busqueda por filtro String
    List<Historieta> findAllWithSearch(String search);
}

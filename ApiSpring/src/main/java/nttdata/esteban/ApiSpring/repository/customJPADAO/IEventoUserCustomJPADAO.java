package nttdata.esteban.ApiSpring.repository.customJPADAO;

import nttdata.esteban.ApiSpring.repository.modelo.EventoUser;

import java.util.List;

public interface IEventoUserCustomJPADAO {

    List<EventoUser> findAllWithSearch(String search);
}

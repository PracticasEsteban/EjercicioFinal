package nttdata.esteban.ApiSpring.repository.jpa;

import nttdata.esteban.ApiSpring.repository.modelo.Historieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHistorietaJPADAO extends JpaRepository<Historieta, Integer> {

    //Query java para ayudar a la consulta
    @Query("select h from Historieta h join fetch h.user u")
    List<Historieta> findAll();
}

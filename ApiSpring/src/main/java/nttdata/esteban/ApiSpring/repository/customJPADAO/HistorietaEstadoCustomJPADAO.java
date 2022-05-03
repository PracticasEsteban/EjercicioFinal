package nttdata.esteban.ApiSpring.repository.customJPADAO;

import nttdata.esteban.ApiSpring.repository.modelo.HistorietaEstado;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class HistorietaEstadoCustomJPADAO implements IHistorietaEstadoCustomJPADAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<HistorietaEstado> findAllWithSearch(String search) {

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("select e from HistorietaEstado e join fetch e.historieta h join fetch e.user u");

        Map<String, Object> parametros = new HashMap<String, Object>();
        List<String> clausulaWhere = new ArrayList<String>();

        this.generateQueryParams(search, clausulaWhere, parametros);

        if (!clausulaWhere.isEmpty()) {
            queryBuilder.append(" where " + StringUtils.join(clausulaWhere, " and "));
        }

        javax.persistence.Query jpaQuery = entityManager.createQuery(queryBuilder.toString());


        for (String key : parametros.keySet()) {
            jpaQuery.setParameter(key, parametros.get(key));
        }


        @SuppressWarnings("unchecked")
        List<HistorietaEstado> historietas = jpaQuery.getResultList();


        return historietas;
    }

    //Separamos los campos del String de la URL, separamos por entidad, atributo condicion y el valor
    private void generateQueryParams(String searchString, List<String> clausulaWhere, Map<String, Object> parametros) {


        Pattern pattern = Pattern.compile("([\\w\\d]+).([\\w\\d]+)(:|<|<=|>=|>|;)([\\w\\d\\.]+)");
        Matcher matcher = pattern.matcher(searchString);

        while (matcher.find()) {

            // Extraemos entidad
            String entidad = matcher.group(1);
            String atributo = matcher.group(2);
            String condicion = matcher.group(3);
            String valor = matcher.group(4);

            //Construimos la condicion

            this.buildCondicion(clausulaWhere, parametros, entidad, atributo, condicion, valor);

        }

    }

    private void buildCondicion(List<String> clausulaWhere, Map<String, Object> parametros, String entidad, String atributo, String condicion, String valor) {

        switch (entidad) {

            case "estado":

                switch (atributo) {
                    case "estado":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" e.estado LIKE :eestado ");
                            parametros.put("eestado", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" e.estado LIKE :eestado ");
                        parametros.put("eestado", valor);
                        break;
                    }

                    case "date":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" e.date = :edate ");
                            parametros.put("edate", valor);
                            break;
                        }
                        break;

                    default:
                        throw new IllegalArgumentException("Condición no valida.");
                }
                break;


            case "historieta":

                switch (atributo) {
                    case "id":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" h.id = :hid ");
                            parametros.put("hid", Integer.parseInt(valor));
                            break;
                        }
                        break;
                    case "text":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" h.text LIKE :htext ");
                            parametros.put("htext", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" h.text LIKE :htext ");
                        parametros.put("htext", valor);
                        break;
                    }

                    case "date":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" h.date = :hdate ");
                            parametros.put("hdate", valor);
                            break;
                        }
                        break;

                    default:
                        throw new IllegalArgumentException("Condición no valida.");
                }
                break;

            case "user":

                switch (atributo) {
                    case "id":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.id = :uid ");
                            parametros.put("uid", Integer.parseInt(valor));
                            break;
                        }
                        break;

                    case "name":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.name LIKE :username ");
                            parametros.put("username", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" u.name LIKE :username");
                        parametros.put("username", valor);
                        break;
                    }

                    case "surnames":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.surnames LIKE :usernamesurnames ");
                            parametros.put("usernamesurnames", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" u.surnames = :usernamesurnames");
                        parametros.put("usernamesurnames", valor);
                        break;
                    }
                        break;


                    case "email":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.email LIKE :uemail ");
                            parametros.put("uemail", "%"+valor+"%");
                            break;
                        }
                        clausulaWhere.add(" u.email = :uemail ");
                        parametros.put("uemail", valor);
                        break;


                    default:
                        throw new IllegalArgumentException("Condición no valida.");
                }

                break;
            default:
                throw new IllegalArgumentException("Condición no valida.");
        }

    }
}

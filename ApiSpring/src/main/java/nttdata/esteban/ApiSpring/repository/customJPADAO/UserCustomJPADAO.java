package nttdata.esteban.ApiSpring.repository.customJPADAO;

import nttdata.esteban.ApiSpring.repository.modelo.User;
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
public class UserCustomJPADAO implements IUserCustomJPADAO{

    /*Clase para obtener consultas filtradas para la tabla user*/

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> findAllWithSearch(String search) {

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("select u from User u");

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
        List<User> listaUser = jpaQuery.getResultList();

        return listaUser;
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

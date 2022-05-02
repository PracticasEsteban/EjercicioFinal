package nttdata.esteban.ApiSpring.repository.customJPADAO;

import nttdata.esteban.ApiSpring.repository.modelo.Friend;
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
public class FriendCustomJPADAO implements IFriendCustomJPADAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Friend> findAllWithSearch(String search) {

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("select f from Friend f join fetch f.userSend us join fetch f.userRecive ur");

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
        List<Friend> listaFriend = jpaQuery.getResultList();

        return  listaFriend;
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

            case "friend":

                switch (atributo) {

                    case "accept":
                        if (condicion.equals(":") && valor.equalsIgnoreCase("true")) {
                            clausulaWhere.add(" f.accept = :faccept ");
                            parametros.put("faccept", "TRUE");
                            break;
                        }
                        if (condicion.equals(":") && valor.equalsIgnoreCase("false")) {
                            clausulaWhere.add(" f.accept = :faccept ");
                            parametros.put("faccept", "FALSE");
                            break;
                        }


                    case "date":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" f.date = :fdate ");
                            parametros.put("fdate", valor);
                            break;
                        }

                    default:
                        throw new IllegalArgumentException("Condición no valida.");
                }
                break;


            case "userSend":

                switch (atributo) {
                    case "id":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" us.id = :usid ");
                            parametros.put("usid", Integer.parseInt(valor));
                            break;
                        }
                        break;

                    case "name":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" us.name LIKE :ussername ");
                            parametros.put("ussername", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" us.name LIKE :ussername");
                        parametros.put("ussername", valor);
                        break;
                    }

                    case "surnames":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" us.surnames LIKE :ussernamesurnames ");
                            parametros.put("ussernamesurnames", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" us.surnames = :ussernamesurnames");
                        parametros.put("ussernamesurnames", valor);
                        break;
                    }
                        break;


                    case "email":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" us.email LIKE :usemail ");
                            parametros.put("usemail", "%"+valor+"%");
                            break;
                        }
                        clausulaWhere.add(" us.email = :usemail ");
                        parametros.put("usemail", valor);
                        break;


                    default:
                        throw new IllegalArgumentException("Condición no valida.");
                }

                break;

            case "userRecive":

                switch (atributo) {
                    case "id":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" ur.id = :urid ");
                            parametros.put("urid", Integer.parseInt(valor));
                            break;
                        }
                        break;

                    case "name":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" ur.name LIKE :ursername ");
                            parametros.put("ursername", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" ur.name LIKE :ursername");
                        parametros.put("ursername", valor);
                        break;
                    }

                    case "surnames":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" ur.surnames LIKE :ursernamesurnames ");
                            parametros.put("ursernamesurnames", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" ur.surnames = :ursernamesurnames");
                        parametros.put("ursernamesurnames", valor);
                        break;
                    }
                        break;


                    case "email":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" ur.email LIKE :uremail ");
                            parametros.put("uremail", "%"+valor+"%");
                            break;
                        }
                        clausulaWhere.add(" ur.email = :uremail ");
                        parametros.put("uremail", valor);
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

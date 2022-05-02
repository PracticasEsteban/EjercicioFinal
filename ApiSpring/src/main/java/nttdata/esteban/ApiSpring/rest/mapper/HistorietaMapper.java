package nttdata.esteban.ApiSpring.rest.mapper;

import nttdata.esteban.ApiSpring.repository.modelo.Historieta;
import nttdata.esteban.ApiSpring.rest.dto.HistorietaDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HistorietaMapper {

    //Traduce un objeto de la clase Historieta(JPA) a HistorietaDTO(REST)

    public static HistorietaDTO map(Historieta historieta, boolean conTodo){

        if (historieta == null) return  null;

        HistorietaDTO historietaDTO = new HistorietaDTO();
        historietaDTO.setId(historieta.getId());
        historietaDTO.setUser(UserMapper.map(historieta.getUser(), false));
        historietaDTO.setDate(historieta.getDate());
        historietaDTO.setText(historieta.getText());

        if (!conTodo) return  historietaDTO;

        //Posible add;



        return historietaDTO;

    }

    //Traduce un objeto Optional(Hisotireta) a HistorietaDTO
    public static HistorietaDTO map(Optional<Historieta> historieta, Boolean conTodo){

        if (historieta.isEmpty())return null;

        return HistorietaMapper.map(historieta.get(), conTodo);
    }

    //Traduce una lista de objetos Historieta(JPA) a una lista de HistorietaDTO

    public static List<HistorietaDTO> map(List<Historieta> historietas, Boolean conTodo){

        if (historietas == null){
            return null;
        }

        if (historietas.isEmpty())return null;

        return historietas.stream()
                .map(x -> HistorietaMapper.map(x , conTodo))
                .collect(Collectors.toList());
    }

    //Traduce un objeto HistorietaDTO a Historieta(JPA)

    public static Historieta map(HistorietaDTO historietaDTO, Boolean conTodo){
        if (historietaDTO == null) return  null;

        Historieta historieta = new Historieta();

        historieta.setId(historietaDTO.getId());
        historieta.setUser(UserMapper.map(historietaDTO.getUser(),false));
        historieta.setDate(historietaDTO.getDate());
        historieta.setText(historieta.getText());
        if (!conTodo) return  historieta;


        return historieta;
    }
}

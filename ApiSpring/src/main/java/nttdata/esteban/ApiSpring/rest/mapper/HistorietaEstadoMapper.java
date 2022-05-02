package nttdata.esteban.ApiSpring.rest.mapper;

import nttdata.esteban.ApiSpring.repository.modelo.Historieta;
import nttdata.esteban.ApiSpring.repository.modelo.HistorietaEstado;
import nttdata.esteban.ApiSpring.rest.dto.HistorietaDTO;
import nttdata.esteban.ApiSpring.rest.dto.HistorietaEstadoDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HistorietaEstadoMapper {

    //Traduce un objeto de la clase HistorietaEstado(JPA) a HistorietaEstadoDTO(REST)

    public static HistorietaEstadoDTO map(HistorietaEstado historietaEstado, boolean conTodo){

        if (historietaEstado == null) return  null;

       HistorietaEstadoDTO historietaEstadoDTO =new HistorietaEstadoDTO();

       historietaEstadoDTO.setId(historietaEstado.getId());
       historietaEstadoDTO.setEstado(historietaEstado.getEstado());
       historietaEstadoDTO.setDate(historietaEstado.getDate());
       historietaEstadoDTO.setHistorieta(HistorietaMapper.map(historietaEstado.getHistorieta(),false));
       historietaEstadoDTO.setUser(UserMapper.map(historietaEstado.getUser(),false));
        if (!conTodo) return  historietaEstadoDTO;

        //Posible add;



        return historietaEstadoDTO;

    }

    //Traduce un objeto Optional(HisotiretaEstado) a HistorietaEstadoDTO
    public static HistorietaEstadoDTO map(Optional<HistorietaEstado> historietaEstado, Boolean conTodo){

        if (historietaEstado.isEmpty())return null;

        return HistorietaEstadoMapper.map(historietaEstado.get(), conTodo);
    }

    //Traduce una lista de objetos HistorietaEstado(JPA) a una lista de HistorietaEstadoDTO

    public static List<HistorietaEstadoDTO> map(List<HistorietaEstado> historietasEstado, Boolean conTodo){

        if (historietasEstado == null){
            return null;
        }

        if (historietasEstado.isEmpty())return null;

        return historietasEstado.stream()
                .map(x -> HistorietaEstadoMapper.map(x , conTodo))
                .collect(Collectors.toList());
    }

    //Traduce un objeto HistorietaEstadoDTO a HistorietaEstado(JPA)

    public static HistorietaEstado map(HistorietaEstadoDTO historietaEstadoDTO, Boolean conTodo){
        if (historietaEstadoDTO == null) return  null;

        HistorietaEstado historietaEstado = new HistorietaEstado();

        historietaEstado.setId(historietaEstadoDTO.getId());
        historietaEstado.setEstado(historietaEstadoDTO.getEstado());
        historietaEstado.setDate(historietaEstadoDTO.getDate());
        historietaEstado.setHistorieta(HistorietaMapper.map(historietaEstadoDTO.getHistorieta(),false));
        historietaEstado.setUser(UserMapper.map(historietaEstadoDTO.getUser(),false));
        if (!conTodo) return  historietaEstado;

        //Posible add

        return historietaEstado;
    }


}

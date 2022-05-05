package nttdata.esteban.ApiSpring.rest.mapper;

import nttdata.esteban.ApiSpring.repository.modelo.Evento;
import nttdata.esteban.ApiSpring.repository.modelo.EventoUser;
import nttdata.esteban.ApiSpring.repository.modelo.User;
import nttdata.esteban.ApiSpring.rest.dto.EventoDTO;
import nttdata.esteban.ApiSpring.rest.dto.EventoUserDTO;
import nttdata.esteban.ApiSpring.rest.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventoMapper {


    //Traduce un objeto Evento(JPA) a EventoDTO
    public static EventoDTO map(Evento evento, boolean conTodo){
        if (evento == null) return null;

        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setId(evento.getId());
        eventoDTO.setName(evento.getName());
        eventoDTO.setDescription(evento.getDescription());
        eventoDTO.setImage(evento.getImage());
        eventoDTO.setDate(evento.getDate());

        if (!conTodo) return eventoDTO;

        //Añadimos arrayList User Evento
        List<EventoUser> eventoUsers = evento.getEventoUser();
        List<EventoUserDTO> eventoUserDTOS = eventoUsers.stream().map(x -> EventoUserMapper.map(x,false)).collect(Collectors.toList());
        eventoDTO.setEventoUser(eventoUserDTOS);


        return eventoDTO;
    }

    //Traduce Optional<Evento> a un EventoDTO
    public static EventoDTO map(Optional<Evento> evento, boolean conTodo){

        if (evento.isEmpty())return null;

        return EventoMapper.map(evento.get(),conTodo);

    }

    //Traduce una lista de EventoJPA a una lista de EventoDTO

    public static List<EventoDTO> map(List<Evento> eventos, boolean conTodo){

        if (eventos == null) return null;
        if (eventos.isEmpty())return  null;

        return eventos.stream().map(x -> EventoMapper.map(x,conTodo)).collect(Collectors.toList());

    }

    //Traduce un EventoDTO a un EventoJPA

    public static Evento map(EventoDTO eventoDTO, boolean conTodo) {

        if (eventoDTO == null) return  null;

        Evento evento = new Evento();
        evento.setId(eventoDTO.getId());
        evento.setDescription(eventoDTO.getDescription());
        evento.setImage(eventoDTO.getImage());
        evento.setDate(eventoDTO.getDate());
        evento.setName(eventoDTO.getName());

        if (!conTodo) return evento;

        //Añadir array list de ususarios al evento
        List<EventoUserDTO> eventoUsersDTO = eventoDTO.getEventoUser();
        List<EventoUser> eventoUser = eventoUsersDTO.stream().map(x -> EventoUserMapper.map(x,false)).collect(Collectors.toList());
        evento.setEventoUser(eventoUser);

        return evento;
    }

}

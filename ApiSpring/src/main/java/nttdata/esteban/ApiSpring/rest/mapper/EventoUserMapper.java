package nttdata.esteban.ApiSpring.rest.mapper;

import nttdata.esteban.ApiSpring.repository.modelo.Evento;
import nttdata.esteban.ApiSpring.repository.modelo.EventoUser;
import nttdata.esteban.ApiSpring.rest.dto.EventoDTO;
import nttdata.esteban.ApiSpring.rest.dto.EventoUserDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventoUserMapper {

    //Traduce un objeto EventoUser(JPA) a EventoUserDTO
    public static EventoUserDTO map(EventoUser eventoUser, boolean conTodo){
        if (eventoUser == null) return null;

        EventoUserDTO eventoDTO = new EventoUserDTO();
        eventoDTO.setId(eventoUser.getId());
        eventoDTO.setUser(UserMapper.map(eventoUser.getUser(),false));
        eventoDTO.setDate(eventoUser.getDate());

        if (!conTodo) return eventoDTO;

        //Añadimos Evento
        eventoDTO.setEvento(EventoMapper.map(eventoUser.getEvento(),false));
        return eventoDTO;
    }

    //Traduce Optional<EventoUser> a un EventoUserDTO
    public static EventoUserDTO map(Optional<EventoUser> evento, boolean conTodo){

        if (evento.isEmpty())return null;

        return EventoUserMapper.map(evento.get(),conTodo);

    }

    //Traduce una lista de EventoUserJPA a una lista de EventoUserDTO

    public static List<EventoUserDTO> map(List<EventoUser> eventos, boolean conTodo){

        if (eventos == null) return null;
        if (eventos.isEmpty())return  null;

        return eventos.stream().map(x -> EventoUserMapper.map(x,conTodo)).collect(Collectors.toList());

    }

    //Traduce un EventoUserDTO a un EventoUserJPA

    public static EventoUser map(EventoUserDTO eventoDTO, boolean conTodo) {

        if (eventoDTO == null) return  null;
        EventoUser evento = new EventoUser();
        evento.setId(eventoDTO.getId());
        evento.setUser(UserMapper.map(eventoDTO.getUser(),false));
        evento.setDate(eventoDTO.getDate());

        if (!conTodo) return evento;

        //Añadimos Evento
        evento.setEvento(EventoMapper.map(eventoDTO.getEvento(),false));

        return evento;
    }



}

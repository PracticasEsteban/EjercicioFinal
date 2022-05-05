package nttdata.esteban.ApiSpring.rest.service;

import nttdata.esteban.ApiSpring.repository.jpa.IEventoJPADAO;
import nttdata.esteban.ApiSpring.repository.modelo.Evento;
import nttdata.esteban.ApiSpring.rest.dto.EventoDTO;
import nttdata.esteban.ApiSpring.rest.mapper.EventoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    IEventoJPADAO iEventoJPADAO;

    public Long count() {
        return this.iEventoJPADAO.count();
    }


    public List<EventoDTO> findAll(Boolean conTodo) {

        List<Evento> eventos = this.iEventoJPADAO.findAll();

        return EventoMapper.map(eventos,conTodo);


    }

    public EventoDTO findById(Integer id, Boolean conTodo) {

        Optional<Evento> evento = this.iEventoJPADAO.findById(id);

        return EventoMapper.map(evento, conTodo);
    }

    public EventoDTO create(EventoDTO eventoDTO) {

        Evento evento = EventoMapper.map(eventoDTO, false);
        evento = this.iEventoJPADAO.save(evento);

        return EventoMapper.map(evento, false);
    }

    public void update(EventoDTO eventoDTO) {

        Evento evento = EventoMapper.map(eventoDTO, false);
        this.iEventoJPADAO.save(evento);

    }

    public void delete(EventoDTO eventoDTO) {
        Evento evento = EventoMapper.map(eventoDTO, false);
        this.iEventoJPADAO.delete(evento);
    }

}

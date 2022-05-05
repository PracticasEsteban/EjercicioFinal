package nttdata.esteban.ApiSpring.rest.service;

import nttdata.esteban.ApiSpring.repository.customJPADAO.IEventoUserCustomJPADAO;
import nttdata.esteban.ApiSpring.repository.jpa.IEventoJPADAO;
import nttdata.esteban.ApiSpring.repository.jpa.IEventoUserJPADAO;
import nttdata.esteban.ApiSpring.repository.modelo.Evento;
import nttdata.esteban.ApiSpring.repository.modelo.EventoUser;
import nttdata.esteban.ApiSpring.rest.dto.EventoDTO;
import nttdata.esteban.ApiSpring.rest.dto.EventoUserDTO;
import nttdata.esteban.ApiSpring.rest.mapper.EventoMapper;
import nttdata.esteban.ApiSpring.rest.mapper.EventoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoUserService {

    @Autowired
    IEventoUserJPADAO iEventoUserJPADAO;

    @Autowired
    IEventoUserCustomJPADAO iEventoUserCustomJPADAO;


    public Long count() {
        return this.iEventoUserJPADAO.count();
    }


    public List<EventoUserDTO> findAll(Boolean conTodo, String search) {

        List<EventoUser> eventosUser = new ArrayList<>();

        if (search.equalsIgnoreCase("false")){
            eventosUser = this.iEventoUserJPADAO.findAll();
        }else{
            eventosUser = this.iEventoUserCustomJPADAO.findAllWithSearch(search);
        }

        return EventoUserMapper.map(eventosUser,conTodo);


    }

    public EventoUserDTO findById(Integer id, Boolean conTodo) {

        Optional<EventoUser> eventoUser = this.iEventoUserJPADAO.findById(id);

        return EventoUserMapper.map(eventoUser, conTodo);
    }

    public EventoUserDTO create(EventoUserDTO eventoUserDTO) {

        EventoUser eventoUser = EventoUserMapper.map(eventoUserDTO, true);
        eventoUser = this.iEventoUserJPADAO.save(eventoUser);

        return EventoUserMapper.map(eventoUser, true);
    }

    public void update(EventoUserDTO eventoUserDTO) {

        EventoUser eventoUser = EventoUserMapper.map(eventoUserDTO, true);
        this.iEventoUserJPADAO.save(eventoUser);

    }

    public void delete(EventoUserDTO eventoUserDTO) {
        EventoUser eventoUser = EventoUserMapper.map(eventoUserDTO, true);
        this.iEventoUserJPADAO.delete(eventoUser);
    }
}

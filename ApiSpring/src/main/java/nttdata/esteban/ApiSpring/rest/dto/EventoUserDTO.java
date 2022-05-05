package nttdata.esteban.ApiSpring.rest.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import nttdata.esteban.ApiSpring.repository.modelo.Evento;
import nttdata.esteban.ApiSpring.repository.modelo.User;

import javax.persistence.*;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventoUserDTO {


    private Integer id;
    private EventoDTO evento;

    private UserDTO user;
    private Date date;

    public EventoUserDTO() {
    }

    public EventoUserDTO(Integer id, EventoDTO evento, UserDTO user, Date date) {
        this.id = id;
        this.evento = evento;
        this.user = user;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EventoDTO getEvento() {
        return evento;
    }

    public void setEvento(EventoDTO evento) {
        this.evento = evento;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

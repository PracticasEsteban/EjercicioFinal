package nttdata.esteban.ApiSpring.rest.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventoDTO {

    private Integer id;
    private String name;
    private String description;
    private Date date;
    private byte[] image;

    //Array list Evento_User
    private List<EventoUserDTO> eventoUser=new ArrayList<>();

    public EventoDTO() {
    }

    public EventoDTO(Integer id, String name, String description, Date date, byte[] image, List<EventoUserDTO> eventoUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.image = image;
        this.eventoUser = eventoUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<EventoUserDTO> getEventoUser() {
        return eventoUser;
    }

    public void setEventoUser(List<EventoUserDTO> eventoUser) {
        this.eventoUser = eventoUser;
    }
}

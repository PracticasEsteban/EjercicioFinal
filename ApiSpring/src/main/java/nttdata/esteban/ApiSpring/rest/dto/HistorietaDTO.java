package nttdata.esteban.ApiSpring.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import nttdata.esteban.ApiSpring.repository.modelo.User;


import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistorietaDTO {

    private Integer id;

    private UserDTO user;

    private String text;
    private Date date;

    public HistorietaDTO() {
    }

    public HistorietaDTO(Integer id, UserDTO user, String text, Date date) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.date = date;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package nttdata.esteban.ApiSpring.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import nttdata.esteban.ApiSpring.repository.modelo.User;


import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FriendDTO {

    private Integer id;
    private UserDTO userSend;
    private UserDTO userRecive;
    private Boolean accept;
    private Date date;


    public FriendDTO() {
    }

    public FriendDTO(Integer id, UserDTO userSend, UserDTO userRecive, Boolean accept, Date date) {
        this.id = id;
        this.userSend = userSend;
        this.userRecive = userRecive;
        this.accept = accept;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUserSend() {
        return userSend;
    }

    public void setUserSend(UserDTO userSend) {
        this.userSend = userSend;
    }

    public UserDTO getUserRecive() {
        return userRecive;
    }

    public void setUserRecive(UserDTO userRecive) {
        this.userRecive = userRecive;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

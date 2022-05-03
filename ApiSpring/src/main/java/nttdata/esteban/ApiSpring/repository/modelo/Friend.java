package nttdata.esteban.ApiSpring.repository.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="friend")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Friend {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_send_id", referencedColumnName = "id")
    private User userSend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_recive_id", referencedColumnName = "id")
    private User userRecive;

    private Boolean accept;
    private Date date;


    public Friend() {
    }

    public Friend(Integer id, User userSend, User userRecive, Boolean accept, Date date) {
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

    public User getUserSend() {
        return userSend;
    }

    public void setUserSend(User userSend) {
        this.userSend = userSend;
    }

    public User getUserRecive() {
        return userRecive;
    }

    public void setUserRecive(User userRecive) {
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

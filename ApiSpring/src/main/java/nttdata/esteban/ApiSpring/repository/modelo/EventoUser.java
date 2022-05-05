package nttdata.esteban.ApiSpring.repository.modelo;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="evento_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Evento evento;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Date date;

    public EventoUser() {
    }

    public EventoUser(Integer id, Evento evento, User user, Date date) {
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

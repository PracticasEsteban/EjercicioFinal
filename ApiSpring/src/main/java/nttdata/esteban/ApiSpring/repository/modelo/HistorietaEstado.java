package nttdata.esteban.ApiSpring.repository.modelo;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="historieta_estado")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistorietaEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historieta_id", referencedColumnName = "id")
    private Historieta historieta;

    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Date date;

    public HistorietaEstado() {
    }

    public HistorietaEstado(Integer id, Historieta historieta, String estado, User user, Date date) {
        this.id = id;
        this.historieta = historieta;
        this.estado = estado;
        this.user = user;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Historieta getHistorieta() {
        return historieta;
    }

    public void setHistorieta(Historieta historieta) {
        this.historieta = historieta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

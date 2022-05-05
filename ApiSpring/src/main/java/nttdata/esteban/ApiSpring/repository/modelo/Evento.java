package nttdata.esteban.ApiSpring.repository.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="evento")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Date date;

    @Lob
    @Column(name="image")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;

    //Array list Evento_User
    @OneToMany(mappedBy = "evento")
    private List<EventoUser> eventoUser=new ArrayList<>();


    public Evento() {
    }

    public Evento(Integer id, String name, String description, Date date, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.image = image;
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

    public List<EventoUser> getEventoUser() {
        return eventoUser;
    }

    public void setEventoUser(List<EventoUser> eventoUser) {
        this.eventoUser = eventoUser;
    }
}

package nttdata.esteban.ApiSpring.repository.modelo;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="historieta")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Historieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String text;
    private Date date;

    public Historieta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

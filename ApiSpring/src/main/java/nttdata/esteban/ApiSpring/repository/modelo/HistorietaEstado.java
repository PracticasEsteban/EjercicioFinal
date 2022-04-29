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

}

package nttdata.esteban.ApiSpring.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;



import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistorietaEstadoDTO {

    private Integer id;

    private HistorietaDTO historieta;

    private String estado;

    private UserDTO user;

    private Date date;

    public HistorietaEstadoDTO() {
    }

    public HistorietaEstadoDTO(Integer id, HistorietaDTO historieta, String estado, UserDTO user, Date date) {
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

    public HistorietaDTO getHistorieta() {
        return historieta;
    }

    public void setHistorieta(HistorietaDTO historieta) {
        this.historieta = historieta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

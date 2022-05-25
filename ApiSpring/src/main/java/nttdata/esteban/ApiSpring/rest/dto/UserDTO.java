package nttdata.esteban.ApiSpring.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {


    private Integer id;
    private String name;
    private String surnames;
    private String email;
    private String description;
    private String image;
    private Date date;


    public UserDTO() {
    }

    public UserDTO(Integer id, String name, String surnames, String email, String description, String image, Date date) {
        this.id = id;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.description = description;
        this.image = image;
        this.date = date;
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

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

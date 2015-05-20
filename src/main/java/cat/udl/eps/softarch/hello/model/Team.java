package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by joanmarc on 20/05/15.
 */
@Entity
public class Team implements Serializable{
    @Id
    @NotBlank(message = "name cannot be blank")
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

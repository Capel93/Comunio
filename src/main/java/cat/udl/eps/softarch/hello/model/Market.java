package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmarc on 20/05/15.
 */
@Entity
@Table
public class Market implements Serializable{

    @Id
    @NotBlank(message = "Community cannot be blank")
    private String community;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    public Market(String community, List<Player> players) {
        this.community = community;
        this.players = players;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}

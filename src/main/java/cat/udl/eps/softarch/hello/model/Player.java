package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by joanmarc on 20/05/15.
 */
@Entity
@Table
public class Player implements Serializable{
    @Id
    @NotBlank(message = "Nick cannot be blank")
    private String nick;

    @NotBlank(message = "Role cannot be blank")
    private String role;

    @NotBlank(message = "Team cannot be blank")
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private Team team;

    @NotBlank(message = "TeamSquad cannot be blank")
    private String teamSquad;

    public Player(String nick, String role, String teamSquad, Team team) {
        this.nick = nick;
        this.role = role;
        this.teamSquad = teamSquad;
        this.team = team;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTeamSquad() {
        return teamSquad;
    }

    public void setTeamSquad(String teamSquad) {
        this.teamSquad = teamSquad;
    }
}

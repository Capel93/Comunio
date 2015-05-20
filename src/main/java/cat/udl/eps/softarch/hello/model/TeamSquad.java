package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmarc on 20/05/15.
 */
@Entity
public class TeamSquad {
    @Id
    @NotBlank(message = "Nick cannot be blank")
    private String name;

    @NotBlank(message = "Nick cannot be blank")
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private User manager;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Player> titularPlayers = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Player> suplentPlayers = new ArrayList<>();

    public TeamSquad(String name, User manager, List<Player> titularPlayers, List<Player> suplentPlayers) {
        this.name = name;
        this.manager = manager;
        this.titularPlayers = titularPlayers;
        this.suplentPlayers = suplentPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public List<Player> getTitularPlayers() {
        return titularPlayers;
    }

    public void setTitularPlayers(List<Player> titularPlayers) {
        this.titularPlayers = titularPlayers;
    }

    public List<Player> getSuplentPlayers() {
        return suplentPlayers;
    }

    public void setSuplentPlayers(List<Player> suplentPlayers) {
        this.suplentPlayers = suplentPlayers;
    }

    public void addPlayer(Player player) {

        this.suplentPlayers.add(player);
        player.setTeamSquad(this.name);

    }

    public void removePlayer(String player) {
        for (Player p:getTitularPlayers()){
            if(p.getNick().equals(player)){
                titularPlayers.remove(p);
                p.setTeamSquad("System");
            }
        }
        for (Player p:getSuplentPlayers()){
            if(p.getNick().equals(player)){
                suplentPlayers.remove(p);
                p.setTeamSquad("System");
            }
        }
    }

    public List<Player> getAllPLayers() {
        List<Player> players = new ArrayList<>();
        players.addAll(this.getTitularPlayers());
        players.addAll(this.getSuplentPlayers());
        return players;
    }

}

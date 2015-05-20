package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by http://rhizomik.net/~roberto/
 */
@Entity
@Table(name = "GreetingsUser") //Avoid collision with system table User in Postgres
public class User {
    @Id
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Email(message = "E-mail should be valid")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Greeting> greetings = new ArrayList<>();

    @NotBlank(message = "teamSquad cannot be blank")
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private TeamSquad teamSquad;

    @NotBlank(message = "community cannot be blank")
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private Community community;


    @URL
    private String imageUrl;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public List<Greeting> getGreetings() {
        return greetings;
    }

    public void addGreeting(Greeting newGreeting) {
        greetings.add(newGreeting);
    }

    public void removeGreeting(Greeting greeting) {
        greetings.remove(greeting);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public TeamSquad getTeamSquad() {
        return teamSquad;
    }

    public void setTeamSquad(TeamSquad teamSquad) {
        this.teamSquad = teamSquad;
    }

    public List<Player> getAllPLayers(){
        return this.teamSquad.getAllPLayers();
    }

    public void addPlayerToTeam(Player player){
        this.teamSquad.addPlayer(player);
    }

    public void sellPlayer(String nick){
        this.teamSquad.removePlayer(nick);
    }
}
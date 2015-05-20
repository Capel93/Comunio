package cat.udl.eps.softarch.hello.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by joanmarc on 20/05/15.
 */
@Entity
public class Bid implements Serializable{
    @Id
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private User user;
    @Id
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private Player player;
    private int bid;

    public Bid(User user, Player player, int bid) {
        this.user = user;
        this.player = player;
        this.bid = bid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}

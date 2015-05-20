package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;

/**
 * Created by joanmarc on 20/05/15.
 */
public interface UserTeamService {

    TeamSquad getUserTeam(String username);

    Player addPlayerToTeamSquad(String username,Player player);

    void removePlayerFromTeamSquad(String username,String playerName);
}

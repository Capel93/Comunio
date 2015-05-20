package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.PlayerRepository;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by joanmarc on 20/05/15.
 */
public class UserTeamServiceImpl implements UserTeamService{

    final Logger logger = LoggerFactory.getLogger(UserTeamServiceImpl.class);

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamSquadRepository teamSquadRepository;

    @Override
    public TeamSquad getUserTeam(String username) {

        //TeamSquad teamSquad = teamSquadRepository.findTeamSquadByUserName(username);
        return null;
    }

    @Override
    public Player addPlayerToTeamSquad(String username,Player player) {
        TeamSquad teamSquad = teamSquadRepository.findTeamSquadByTeamSquadName(player.getTeamSquad());
        teamSquad.addPlayer(player);
        return null;
    }

    @Override
    public void removePlayerFromTeamSquad(String username,String playerName) {
        //TeamSquad teamSquad = teamSquadRepository.findTeamSquadByUserName(username);
        //teamSquad.removePlayer(playerName);
    }
}

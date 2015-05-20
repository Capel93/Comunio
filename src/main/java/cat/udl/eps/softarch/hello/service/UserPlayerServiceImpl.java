package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.GreetingRepository;
import cat.udl.eps.softarch.hello.repository.PlayerRepository;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joanmarc on 20/05/15.
 */
@Service
public class UserPlayerServiceImpl implements UserPlayerService{

    //final Logger logger = LoggerFactory.getLogger(UserPlayerServiceImpl.class);

    //@Autowired
    //PlayerRepository playerRepository;
    @Autowired
    UserRepository userRepository;
    //@Autowired
    //TeamSquadRepository teamSquadRepository;


    //@Transactional
    @Override
    public User getUserAndPlayers(String username) {
        User u = userRepository.findOne(username);
        //logger.info("User {} has {} players", u.getUsername(), u.getAllPLayers().size());
        return u;
    }

    //@Transactional
    @Override
    public Player addPlayerToUser(String username,Player player) {
        //TeamSquad teamSquad = teamSquadRepository.findTeamSquadByUserName(username);
        //teamSquad.addPlayer(player);
        return player;
    }

    //@Transactional
    @Override
    public void removePlayerFromUser(String username,String playerName) {
        //TeamSquad teamSquad = teamSquadRepository.findTeamSquadByUserName(username);
        //teamSquad.removePlayer(playerName);
    }
}

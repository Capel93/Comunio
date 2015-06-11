package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.*;
import cat.udl.eps.softarch.hello.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmarc on 21/05/15.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    TeamSquadRepository teamSquadRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamSquadPlayerService teamSquadPlayerService;

    @Autowired
    TeamRepository teamRepository;

    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Transactional
    @Override
    public User getUser(String username) {
        return userRepository.findOne(username);
    }


    @Transactional
    @Override
    public User addUser(User user) {



        TeamSquad teamSquad = new TeamSquad();
        teamSquad.setName(user.getTeamSquad());
        teamSquad.setManager(user.getUsername());

        logger.info("teamSquad not save");

        //List<Player> titularPlayers = new ArrayList<>();
        //Team t1 = new Team("FCB");
        //teamRepository.save(t1);
        //Player p1 = new Player("Joan","DC",user.getTeamSquad(),t1);
        //playerRepository.save(p1);
        //Team t2 = new Team("AND");
        //teamRepository.save(t2);
        //Player p2 = new Player("Victor","DF",user.getTeamSquad(),t2);
        //playerRepository.save(p2);
        //titularPlayers.add();
        //titularPlayers.add(p2);
        //teamSquad.setTitularPlayers(titularPlayers);

        logger.info("titular players save");

        //List<Player> suplentPlayers = new ArrayList<>();
        //Team t3 = new Team("UEL");
        //teamRepository.save(t3);
        //Player p3 = new Player("Guille","LD",user.getTeamSquad(),t3);
        //playerRepository.save(p3);
        //Player p4 = new Player("Sergi","LI",user.getTeamSquad(),t3);
        //playerRepository.save(p4);
        //suplentPlayers.add(p3);
        //suplentPlayers.add(p4);
        //teamSquad.setSuplentPlayers(suplentPlayers);
        //logger.info("suplent players save");

        TeamSquad savedTeam = teamSquadRepository.save(teamSquad);
        logger.info("teamSquad save");

        List<Player> players = playerRepository.findAll();
        //teamSquadPlayerService.addTitularPlayer(savedTeam.getName(), playerRepository.findOne("Joan"));
        //teamSquadPlayerService.addTitularPlayer(savedTeam.getName(), playerRepository.findOne("Victor"));
        //teamSquadPlayerService.addSuplentPlayer(savedTeam.getName(), playerRepository.findOne("Guille"));
        //teamSquadPlayerService.addSuplentPlayer(savedTeam.getName(), playerRepository.findOne("Sergi"));
        logger.info("players added save");



        //Community community;
        //if(communityRepository.findOne(user.getCommunity())==null){
            /*community = new Community();
            community.setName(user.getCommunity());
            community.setAdmin(user);
            community.addUser(user);
            communityRepository.save(community);*/
        //}else{
        //    community = communityRepository.findOne(user.getCommunity());
        //}

        User u = userRepository.save(user);
        return u;


    }

    @Override
    public User updateUser(User user, String username) {
        User oldUser = userRepository.findOne(username);
        oldUser.setTeamSquad(user.getTeamSquad());
        oldUser.setEmail(user.getEmail());
        oldUser.setCommunity(user.getCommunity());
        oldUser.setUsername(user.getUsername());
        return oldUser;
    }

    private TeamSquad setPlayerList(){
        TeamSquad teamSquad = new TeamSquad();
        List<Player> titularPlayers = new ArrayList<>();
        titularPlayers.add(new Player("Joan","DC","JoanTeam","FCB"));
        titularPlayers.add(new Player("Victor","DF","JoanTeam","AND"));
        teamSquad.setTitularPlayers(titularPlayers);
        List<Player> suplentPlayers = new ArrayList<>();
        suplentPlayers.add(new Player("Guille","LD","JoanTeam","UEL"));
        suplentPlayers.add(new Player("Sergi","LI","JoanTeam","UEL"));
        teamSquad.setSuplentPlayers(suplentPlayers);
        return teamSquad;
    }
}

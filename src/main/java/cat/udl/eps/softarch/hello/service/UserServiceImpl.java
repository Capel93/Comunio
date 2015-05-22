package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.*;
import cat.udl.eps.softarch.hello.repository.CommunityRepository;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    CommunityRepository communityRepository;

    @Override
    public User getUser(String username) {
        return userRepository.findOne(username);
    }



    @Override
    public User addUser(User user) {

        userRepository.save(user);

        TeamSquad teamSquad = new TeamSquad();
        teamSquad.setName(user.getTeamSquad());
        teamSquad.setManager(user.getUsername());
        List<Player> titularPlayers = new ArrayList<>();
        titularPlayers.add(new Player("Joan","DC","JoanTeam",new Team("FCB")));
        titularPlayers.add(new Player("Victor","DF","JoanTeam",new Team("AND")));
        teamSquad.setTitularPlayers(titularPlayers);
        List<Player> suplentPlayers = new ArrayList<>();
        suplentPlayers.add(new Player("Guille","LD","JoanTeam",new Team("UEL")));
        suplentPlayers.add(new Player("Sergi","LI","JoanTeam",new Team("UEL")));
        teamSquad.setSuplentPlayers(suplentPlayers);
        teamSquadRepository.save(teamSquad);




        Community community;
        //if(communityRepository.findOne(user.getCommunity())==null){
            community = new Community();
            community.setName(user.getCommunity());
            community.setAdmin(user);
            community.addUser(user);
            communityRepository.save(community);
        //}else{
        //    community = communityRepository.findOne(user.getCommunity());
        //}

        return user;

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
        titularPlayers.add(new Player("Joan","DC","JoanTeam",new Team("FCB")));
        titularPlayers.add(new Player("Victor","DF","JoanTeam",new Team("AND")));
        teamSquad.setTitularPlayers(titularPlayers);
        List<Player> suplentPlayers = new ArrayList<>();
        suplentPlayers.add(new Player("Guille","LD","JoanTeam",new Team("UEL")));
        suplentPlayers.add(new Player("Sergi","LI","JoanTeam",new Team("UEL")));
        teamSquad.setSuplentPlayers(suplentPlayers);
        return teamSquad;
    }
}

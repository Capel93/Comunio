package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.repository.PlayerRepository;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joanmarc on 11/06/15.
 */
@Service
public class TeamSquadPlayerServiceImpl implements TeamSquadPlayerService{

    @Autowired
    TeamSquadRepository teamSquadRepository;

    @Autowired
    PlayerRepository playerRepository;

    final Logger logger = LoggerFactory.getLogger(TeamSquadPlayerServiceImpl.class);

    @Transactional
    @Override
    public TeamSquad addTitularPlayer(String teamSquadName, Player player) {

        logger.info("find team squad");

        TeamSquad team = teamSquadRepository.findTeamSquadByName(teamSquadName);
        logger.info(" founded");

        team.addTitularPlayer(player);
        player.setTeamSquad(teamSquadName);
        playerRepository.save(player);
        logger.info("player saved");
        return teamSquadRepository.save(team);
    }

    @Transactional
    @Override
    public TeamSquad addSuplentPlayer(String teamSquadName, Player player) {

        TeamSquad team = teamSquadRepository.findTeamSquadByName(teamSquadName);
        team.addSuplentPlayer(player);
        player.setTeamSquad(teamSquadName);
        playerRepository.save(player);

        return teamSquadRepository.save(team);
    }

    @Transactional
    @Override
    public void removePlayer(Player player) {

    }
}

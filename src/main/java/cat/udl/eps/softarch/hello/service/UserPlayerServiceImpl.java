package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import cat.udl.eps.softarch.hello.xQuery.XQueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Player> getPlayers() {

        //map id-nom
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i <XQueryHelper.teamsId.length ; i++) {

            String team = XQueryHelper.apiTeamBase+XQueryHelper.teamsId[i];
            ArrayList<XQueryHelper.Player> jugadors = new ArrayList<XQueryHelper.Player>();
            XQueryHelper xQueryHelperPlayers = null;
            try {
                xQueryHelperPlayers = new XQueryHelper(XQueryHelper.playerXQ, new URL(team));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (XQException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            try {
                jugadors.addAll(xQueryHelperPlayers.getPlayers(XQueryHelper.teamsId[i]));

                Player p;
                for (XQueryHelper.Player player:jugadors ){
                    p = new Player();
                    p.setNick(player.getNick());
                    p.setRole(player.getRole());
                    p.setTeam(XQueryHelper.teamsName[i]);
                    p.setCurrentPoints(3);
                    p.setTotalPoints(54);
                    p.setPrice(5000000);
                    players.add(p);

                }

            } catch (JAXBException e) {
                e.printStackTrace();
            }


        }



        System.out.println(players);

        return players;



    }

}

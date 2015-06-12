package cat.udl.eps.softarch.hello.controller.html;

import cat.udl.eps.softarch.hello.controller.MarketController;
import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.repository.CommunityRepository;
import cat.udl.eps.softarch.hello.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by joanmarc on 12/06/15.
 */
@Controller
@RequestMapping(value = "/market")
public class MarketControllerHTML {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    MarketController marketController;

    // LIST
    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHTML(@RequestParam(required=false, defaultValue="0") int page,
                                 @RequestParam(required=false, defaultValue="200") int size) {

        List<Player> players = marketController.list(page,size);
        for (Player p:players){
            System.out.println("player nick ::::: "+p.getNick());
        }

        return new ModelAndView("market", "players", players);
    }


}

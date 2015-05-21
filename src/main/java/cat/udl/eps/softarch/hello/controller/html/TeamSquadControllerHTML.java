package cat.udl.eps.softarch.hello.controller.html;


import cat.udl.eps.softarch.hello.controller.TeamSquadController;
import cat.udl.eps.softarch.hello.model.Greeting;
import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.Team;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import cat.udl.eps.softarch.hello.service.UserTeamService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by joanmarc on 21/05/15.
 */
@Controller
@RequestMapping(value = "/teamSquads")
public class TeamSquadControllerHTML {

    @Autowired
    UserTeamService userTeamService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TeamSquadController teamSquadController;
    @Autowired
    TeamSquadRepository teamSquadRepository;

    // LIST
    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHTML(@RequestParam(required=false, defaultValue="0") int page,
                                 @RequestParam(required=false, defaultValue="10") int size) {
        return new ModelAndView("teamSquads", "teamSquads", teamSquadController.list(page, size));
    }

    // RETRIEVE
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHTML(@PathVariable( "id" ) Long id) {
        return new ModelAndView("teamSquad", "teamSquad", teamSquadController.retrieve(id));
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded", produces="text/html")
    public String createHTML(@Valid @ModelAttribute("teamSquad") TeamSquad teamSquad, BindingResult binding, HttpServletResponse response) {
        /*if (binding.hasErrors()) {

            return "teamSquadForm";
        }*/

        return "redirect:teamSquads/"+teamSquadController.create(teamSquad, response).getId();
    }

    // Create form
    @RequestMapping(value = "/teamSquadForm/{username}", method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/html")
    public ModelAndView createForm(@PathVariable("username") String username) {

        TeamSquad emptyTeamSquad = new TeamSquad();
        List<Player> titularPlayers = new ArrayList<>();
        titularPlayers.add(new Player("Joan","DC","JoanTeam",new Team("FCB")));
        titularPlayers.add(new Player("Victor","DF","JoanTeam",new Team("AND")));
        emptyTeamSquad.setTitularPlayers(titularPlayers);
        List<Player> suplentPlayers = new ArrayList<>();
        suplentPlayers.add(new Player("Guille","LD","JoanTeam",new Team("UEL")));
        suplentPlayers.add(new Player("Sergi","LI","JoanTeam",new Team("UEL")));
        emptyTeamSquad.setSuplentPlayers(suplentPlayers);
        emptyTeamSquad.setManager(userRepository.findOne(username));

        return new ModelAndView("teamSquadForm", "teamSquad", emptyTeamSquad);
    }

    // UPDATE
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.OK)
    public String updateHTML(@PathVariable("id") Long id, @Valid @ModelAttribute("greeting") TeamSquad teamSquad, BindingResult binding) {
        /*if (binding.hasErrors()) {

            return "teamSquadForm";
        }*/
        return "redirect:"+teamSquadController.update(id,teamSquad);
    }
    // Update form
    @RequestMapping(value = "/{id}/teamSquadForm", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView updateForm(@PathVariable("id") Long id) {
        Preconditions.checkNotNull(teamSquadRepository.findOne(id), "teamSquad with id %s not found", id);
        return new ModelAndView("teamSquadForm", "teamSquad", teamSquadRepository.findOne(id));
    }
}

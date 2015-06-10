package cat.udl.eps.softarch.hello.controller.html;

import cat.udl.eps.softarch.hello.controller.UserController;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by joanmarc on 27/05/15.
 */
@Controller
@RequestMapping(value = "/main")
public class MainControllerHTML {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserController userController;

    // CREATE
    @RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded", produces="text/html")
    public String createHTML(@ModelAttribute("user") User user, BindingResult binding, HttpServletResponse response) {

        return "redirect:signIn/"+userController.create(user, response).getUsername();
    }

    // Create form
    @RequestMapping(value = "/signIn", method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/html")
    public ModelAndView main() {

        User emptyUser = new User();

        return new ModelAndView("mainForm", "user", emptyUser);
    }

    // Create form
    @RequestMapping(value = "/register", method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/html")
    public ModelAndView createForm() {

        User emptyUser = new User();

        return new ModelAndView("userForm", "user", emptyUser);
    }
}

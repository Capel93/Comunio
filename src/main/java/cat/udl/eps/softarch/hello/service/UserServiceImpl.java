package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joanmarc on 21/05/15.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String username) {
        return userRepository.findOne(username);
    }



    @Override
    public User addUser(User user) {

        return userRepository.save(user);
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
}

package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.User;

/**
 * Created by joanmarc on 21/05/15.
 */
public interface UserService {
    User getUser(String username);



    User addUser(User user);

    User updateUser(User teamSquad, String username);
}

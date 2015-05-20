package cat.udl.eps.softarch.hello.repository;


import cat.udl.eps.softarch.hello.model.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by joanmarc on 20/05/15.
 */
public interface PlayerRepository extends PagingAndSortingRepository<Player, String> {

    List<Player> findByContentContaining(@Param("nick") String nick);
}

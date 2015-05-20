package cat.udl.eps.softarch.hello.repository;



import cat.udl.eps.softarch.hello.model.TeamSquad;
import org.springframework.data.repository.query.Param;

/**
 * Created by joanmarc on 20/05/15.
 */
public interface TeamSquadRepository {
    //TeamSquad findTeamSquadByUserName(@Param("username") String userName);

    TeamSquad findTeamSquadByTeamSquadName(@Param("name") String name);

}
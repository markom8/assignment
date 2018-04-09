package match;

import com.htec.championship.ChampionshipApplication;
import com.htec.championship.match.MatchEntity;
import com.htec.championship.match.MatchService;
import com.htec.championship.team.TeamEntity;
import com.htec.championship.team.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChampionshipApplication.class)
public class MatchServiceTest {

    @Autowired
    private MatchService matchService;

    @Autowired
    private TeamService teamService;

    @Test
    @Transactional
    public void saveTeam() {
        MatchEntity matchEntity = matchService.saveMatch(
                new MatchEntity(1, teamService.saveTeam(new TeamEntity("Barselona")),
                                teamService.saveTeam(new TeamEntity("Real")), new Date(), "1:1"));
        System.out.println(matchEntity.toString());
    }

}

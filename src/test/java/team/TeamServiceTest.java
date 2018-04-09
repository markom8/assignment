package team;

import com.htec.championship.ChampionshipApplication;
import com.htec.championship.team.TeamEntity;
import com.htec.championship.team.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChampionshipApplication.class)
public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Test
    @Transactional
    public void saveTeam() {
        TeamEntity teamEntity = teamService.saveTeam(new TeamEntity("Barselona"));
        System.out.println(teamEntity.toString());
    }

}

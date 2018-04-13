package league;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.htec.championship.ChampionshipApplication;
import com.htec.championship.league.LeagueEndpoint;
import com.htec.championship.league.LeagueFacade;
import com.htec.championship.team.TeamEndpoint;
import com.htec.championship.team.TeamFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChampionshipApplication.class)
public class LeagueEndpointTest {

    private MockMvc mockMvc;

    @Autowired
    private LeagueFacade leagueFacade;


    /*
    1.	Napraviti API endpoint koji će primiti sve rezultate utakmica jedne grupe lige sampiona u fudbalu u JSON formatu
    (primer: prilog 1) i vratiti konačnu tabelu ove grupe.
     */

//    @Test
//    @Transactional
//    public void testAddResultsAndUpdateLeague() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(new LeagueEndpoint(leagueFacade)).build();
//        mockMvc.perform(
//                post("/api/league").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"teamName\":\"Barselona\"}"))
//               .andDo(print()).andExpect(status().isCreated())
//               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//               .andExpect(content().json("{\"teamName\":\"Barselona\"}"));
//    }
}

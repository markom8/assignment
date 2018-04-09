package team;

import com.htec.championship.ChampionshipApplication;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChampionshipApplication.class)
public class TeamEndpointTest {

    private MockMvc mockMvc;

    @Autowired
    private TeamFacade teamFacade;

    @Test
    @Transactional
    public void testSaveDriver() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new TeamEndpoint(teamFacade)).build();
        mockMvc.perform(
                post("/api/team").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"teamName\":\"Barselona\"}"))
               .andDo(print()).andExpect(status().isCreated())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(content().json("{\"teamName\":\"Barselona\"}"));
    }
}

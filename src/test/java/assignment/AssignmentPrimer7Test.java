package assignment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.htec.championship.ChampionshipApplication;
import com.htec.championship.result.ResultsEndpoint;
import com.htec.championship.result.ResultsFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChampionshipApplication.class)
public class AssignmentPrimer7Test {

    private MockMvc mockMvc;

    @Autowired
    private ResultsFacade resultsFacade;


    /*
    1.	Napraviti API endpoint koji će primiti sve rezultate utakmica jedne grupe lige sampiona u fudbalu u JSON formatu
    (primer: prilog 1) i vratiti konačnu tabelu ove grupe.

     https://en.wikipedia.org/wiki/2017%E2%80%9318_UEFA_Champions_League_group_stage#cite_ref-table_hth_PAR0.29367909966674_15-1

         :-)
     */

    @Test
    @Transactional
    public void testCreateOrUpdateResultReturnTablePrimer7() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        String leagueResults=mapper.writeValueAsString(mapper.readValue(new File(classLoader.getResource("assignmentPrimer7/leagueResultsInput").getFile()),Object.class));
        String leagueTable=mapper.writeValueAsString(mapper.readValue(new File(classLoader.getResource("assignmentPrimer7/leagueTableOutput").getFile()),Object.class));
        mockMvc = MockMvcBuilders.standaloneSetup(new ResultsEndpoint(resultsFacade)).build();
        mockMvc.perform(
                post("/api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content(leagueResults))
                       .andDo(print()).andExpect(status().isCreated())
                       .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                       .andExpect(content().json(leagueTable));
    }

    @Test
    @Transactional
    public void testCreateOrUpdateResultReturnTablePrimer7_1() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        String leagueResults=mapper.writeValueAsString(mapper.readValue(new File(classLoader.getResource("assignmentPrimer7/leagueResultsInput").getFile()),Object.class));
        String leagueResults1=mapper.writeValueAsString(mapper.readValue(new File(classLoader.getResource("assignmentPrimer7/leagueResultsInput1").getFile()),Object.class));
        String leagueTable=mapper.writeValueAsString(mapper.readValue(new File(classLoader.getResource("assignmentPrimer7/leagueTableOutput1").getFile()),Object.class));
        String leagueTable1=mapper.writeValueAsString(mapper.readValue(new File(classLoader.getResource("assignmentPrimer7/leagueTableOutput1").getFile()),Object.class));
        mockMvc = MockMvcBuilders.standaloneSetup(new ResultsEndpoint(resultsFacade)).build();
        mockMvc.perform(
                post("/api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content(leagueResults))
               .andDo(print()).andExpect(status().isCreated());
        mockMvc.perform(
                post("/api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content(leagueResults1))
               .andDo(print()).andExpect(status().isCreated())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(content().json(leagueTable1));
    }

}

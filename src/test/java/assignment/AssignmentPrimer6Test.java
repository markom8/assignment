package assignment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.htec.championship.ChampionshipApplication;
import com.htec.championship.league.LeagueEndpoint;
import com.htec.championship.league.LeagueFacade;
import com.htec.championship.result.ResultsEndpoint;
import com.htec.championship.result.ResultsFacade;
import org.h2.store.fs.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class AssignmentPrimer6Test {

    private static ObjectMapper mapper;
    private static String leagueResults;
    private static String leagueTable;
    private static String leagueTable1;
    private static String leagueTable2;
    private static String leagueTable3;
    private static String leagueTable4;

    private MockMvc mockMvcLeague;
    private MockMvc mockMvcResult;

    @Autowired
    private LeagueFacade leagueFacade;

    @Autowired
    private ResultsFacade resultsFacade;

    @BeforeClass
    public static void prepare() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AssignmentPrimer6Test.class.getClassLoader();
         leagueResults = mapper.writeValueAsString(
                mapper.readValue(new File(classLoader.getResource("assignmentPrimer6/leagueResultsInput").getFile()),
                                 Object.class));
         leagueTable = mapper.writeValueAsString(
                mapper.readValue(new File(classLoader.getResource("assignmentPrimer6/leagueTableOutput").getFile()),
                                 Object.class));
         leagueTable1 = mapper.writeValueAsString(
                mapper.readValue(new File(classLoader.getResource("assignmentPrimer6/leagueTableOutput1").getFile()),
                                 Object.class));
         leagueTable2 = mapper.writeValueAsString(
                mapper.readValue(new File(classLoader.getResource("assignmentPrimer6/leagueTableOutput2").getFile()),
                                 Object.class));
         leagueTable3 = mapper.writeValueAsString(
                mapper.readValue(new File(classLoader.getResource("assignmentPrimer6/leagueTableOutput3").getFile()),
                                 Object.class));
         leagueTable4 = mapper.writeValueAsString(
                mapper.readValue(new File(classLoader.getResource("assignmentPrimer6/leagueTableOutput4").getFile()),
                                 Object.class));

    }

    @Before
    public void setup() throws Exception {
        this.mockMvcLeague = MockMvcBuilders.standaloneSetup(new LeagueEndpoint(leagueFacade)).build();
        this.mockMvcResult = MockMvcBuilders.standaloneSetup(new ResultsEndpoint(resultsFacade)).build();
    }



    /*
        6.	Napraviti API endpoint koji će omogućiti vraćanje ubačenih (trenutnih) rezultata gde je omogućeno
        filtriranje po datumu (od - do), grupi i timu,
        i to tako da se može filtrirati bilo kojom kombinacijom filtera (npr. jedan filter, svi fiteri, bez filtera..)
     */

    @Test
    @Transactional
    public void testSearchResultsOfLeaguePrimer6() throws Exception {
        mockMvcResult.perform(
                post("/api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content(leagueResults))
                     .andDo(print()).andExpect(status().isCreated());

        mockMvcLeague.perform(post("/api/league/search").contentType(MediaType.APPLICATION_JSON_UTF8).content(
                "    {\n" + "        \"dateFrom\": \"2016-09-13T20:45:00\",\n"
                        + "        \"dateTo\": \"2019-09-13T20:45:00\",\n" + "        \"groupName\": \"A\",\n"
                        + "        \"teamName\": \"Basel\"\n" + "    }")).andDo(print())
                     .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                     .andExpect(content().json(leagueTable));
    }

    @Test
    @Transactional
    public void testSearchResultsOfLeaguePrimer6_1() throws Exception {

        mockMvcResult.perform(
                post("/api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content(leagueResults))
                     .andDo(print()).andExpect(status().isCreated());


        mockMvcLeague.perform(post("/api/league/search").contentType(MediaType.APPLICATION_JSON_UTF8)
                                                        .content("{\n"
                                                                         + "        \"dateFrom\": \"2016-09-13T20:45:00\",\n"
                                                                         + "        \"dateTo\": \"2019-09-13T20:45:00\",\n"
                                                                         + "        \"groupName\": \"A\"\n" + "    }")).andDo(print())
                     .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                     .andExpect(content().json(leagueTable1));

    }

    @Test
    @Transactional
    public void testSearchResultsOfLeaguePrimer6_2() throws Exception {

        mockMvcResult.perform(
                post("/api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content(leagueResults))
                     .andDo(print()).andExpect(status().isCreated());


        mockMvcLeague.perform(post("/api/league/search").contentType(MediaType.APPLICATION_JSON_UTF8)
                                                        .content("    {\n"
                                                                         + "        \"dateFrom\": "
                                                                         + "\"2016-09-13T20:45:00\",\n"
                                                                         + "        \"dateTo\": "
                                                                         + "\"2019-09-13T20:45:00\"\n"
                                                                         + "    }")).andDo(print())
                     .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                     .andExpect(content().json(leagueTable2));

    }

    @Test
    @Transactional
    public void testSearchResultsOfLeaguePrimer6_3() throws Exception {

        mockMvcResult.perform(
                post("/api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content(leagueResults))
                     .andDo(print()).andExpect(status().isCreated());


        mockMvcLeague.perform(post("/api/league/search").contentType(MediaType.APPLICATION_JSON_UTF8)
                                                        .content("    {\n"
                                                                         + "        \"dateFrom\": "
                                                                         + "\"2016-09-13T20:45:00\"\n"
                                                                         + "    }")).andDo(print())
                     .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                     .andExpect(content().json(leagueTable3));

    }

    @Test
    @Transactional
    public void testSearchResultsOfLeaguePrimer6_4() throws Exception {

        mockMvcResult.perform(
                post("/api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content(leagueResults))
                     .andDo(print()).andExpect(status().isCreated());


        mockMvcLeague.perform(post("/api/league/search").contentType(MediaType.APPLICATION_JSON_UTF8)
                                                        .content("{}")).andDo(print())
                     .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                     .andExpect(content().json(leagueTable4));

    }

}

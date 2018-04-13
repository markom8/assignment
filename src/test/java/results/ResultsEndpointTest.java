package results;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChampionshipApplication.class)
public class ResultsEndpointTest {

    private MockMvc mockMvc;

    @Autowired
    private ResultsFacade resultsFacade;


    /*
    1.	Napraviti API endpoint koji će primiti sve rezultate utakmica jedne grupe lige sampiona u fudbalu u JSON formatu
    (primer: prilog 1) i vratiti konačnu tabelu ove grupe.
     */

    @Test
    @Transactional
    public void testCreateOrUpdateResultReturnTablePrimer1() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(new ResultsEndpoint(resultsFacade)).build();
        mockMvc.perform(
                post("api/results/grouped-table").contentType(MediaType.APPLICATION_JSON_UTF8).content("[\n" + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"PSG\",\n"
                                                                                                 + "        \"awayTeam\": \"Arsenal\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-09-13T20:45:00\",\n"
                                                                                                 + "        \"score\": \"1:1\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"Basel\",\n"
                                                                                                 + "        \"awayTeam\": \"Ludogorets\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-09-13T20:45:00\",\n"
                                                                                                 + "        \"score\": \"1:1\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 2,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"Arsenal\",\n"
                                                                                                 + "        \"awayTeam\": \"Basel\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-09-28T20:45:00\",\n"
                                                                                                 + "        \"score\": \"2:0\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 2,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"Ludogorets\",\n"
                                                                                                 + "        \"awayTeam\": \"PSG\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-09-28T20:45:00\",\n"
                                                                                                 + "        \"score\": \"1:3\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"Arsenal\",\n"
                                                                                                 + "        \"awayTeam\": \"Ludogorets\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-10-19T20:45:00\",\n"
                                                                                                 + "        \"score\": \"6:0\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"PSG\",\n"
                                                                                                 + "        \"awayTeam\": \"Basel\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-10-19T20:45:00\",\n"
                                                                                                 + "        \"score\": \"3:0\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"Ludogorets\",\n"
                                                                                                 + "        \"awayTeam\": \"Arsenal\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-11-01T20:45:00\",\n"
                                                                                                 + "        \"score\": \"2:3\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"PSG\",\n"
                                                                                                 + "        \"awayTeam\": \"Basel\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-11-01T20:45:00\",\n"
                                                                                                 + "        \"score\": \"1:2\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"Arsenal\",\n"
                                                                                                 + "        \"awayTeam\": \"PSG\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-23-11T20:45:00\",\n"
                                                                                                 + "        \"score\": \"2:2\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"Ludogorets\",\n"
                                                                                                 + "        \"awayTeam\": \"Basel\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-23-11T20:45:00\",\n"
                                                                                                 + "        \"score\": \"0:0\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"Basel\",\n"
                                                                                                 + "        \"awayTeam\": \"Arsenal\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-12-07T20:45:00\",\n"
                                                                                                 + "        \"score\": \"1:4\"\n"
                                                                                                 + "    },\n"
                                                                                                 + "    {\n"
                                                                                                 + "        \"leagueTitle\": \"Champions league 2016/17\",\n"
                                                                                                 + "        \"matchday\": 1,\n"
                                                                                                 + "        \"group\": \"A\",\n"
                                                                                                 + "        \"homeTeam\": \"PSG\",\n"
                                                                                                 + "        \"awayTeam\": \"Ludogorets\",\n"
                                                                                                 + "        \"kickoffAt\": \"2017-12-07T20:45:00\",\n"
                                                                                                 + "        \"score\": \"2:2\"\n"
                                                                                                 + "    }\n" + "]\n\"}"))
               .andDo(print()).andExpect(status().isCreated())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(content().json("{\n" + "    \"leagueName\": \"Champions league 2016/17\",\n"
                                                 + "    \"tableGroupRecords\": [\n" + "        {\n"
                                                 + "            \"matchday\": 6,\n" + "            \"standing\": [\n"
                                                 + "                {\n" + "                    \"rank\": 1,\n"
                                                 + "                    \"playedGames\": 6,\n"
                                                 + "                    \"points\": 14,\n"
                                                 + "                    \"goals\": 18,\n"
                                                 + "                    \"goalsAgainst\": 6,\n"
                                                 + "                    \"goalDifference\": 12,\n"
                                                 + "                    \"win\": 4,\n"
                                                 + "                    \"lose\": 0,\n"
                                                 + "                    \"draw\": 2,\n"
                                                 + "                    \"team\": \"Arsenal\"\n"
                                                 + "                },\n" + "                {\n"
                                                 + "                    \"rank\": 2,\n"
                                                 + "                    \"playedGames\": 6,\n"
                                                 + "                    \"points\": 9,\n"
                                                 + "                    \"goals\": 12,\n"
                                                 + "                    \"goalsAgainst\": 8,\n"
                                                 + "                    \"goalDifference\": 4,\n"
                                                 + "                    \"win\": 2,\n"
                                                 + "                    \"lose\": 1,\n"
                                                 + "                    \"draw\": 3,\n"
                                                 + "                    \"team\": \"PSG\"\n" + "                },\n"
                                                 + "                {\n" + "                    \"rank\": 3,\n"
                                                 + "                    \"playedGames\": 6,\n"
                                                 + "                    \"points\": 5,\n"
                                                 + "                    \"goals\": 4,\n"
                                                 + "                    \"goalsAgainst\": 11,\n"
                                                 + "                    \"goalDifference\": -7,\n"
                                                 + "                    \"win\": 1,\n"
                                                 + "                    \"lose\": 3,\n"
                                                 + "                    \"draw\": 2,\n"
                                                 + "                    \"team\": \"Basel\"\n" + "                },\n"
                                                 + "                {\n" + "                    \"rank\": 4,\n"
                                                 + "                    \"playedGames\": 6,\n"
                                                 + "                    \"points\": 3,\n"
                                                 + "                    \"goals\": 6,\n"
                                                 + "                    \"goalsAgainst\": 15,\n"
                                                 + "                    \"goalDifference\": -9,\n"
                                                 + "                    \"win\": 0,\n"
                                                 + "                    \"lose\": 3,\n"
                                                 + "                    \"draw\": 3,\n"
                                                 + "                    \"team\": \"Ludogorets\"\n"
                                                 + "                }\n" + "            ],\n"
                                                 + "            \"group\": \"A\"\n" + "        }\n" + "    ]\n" + "}"));
    }
}

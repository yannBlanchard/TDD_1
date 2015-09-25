package fr.p10.miage.rps.tests;

import fr.p10.miage.rps.model.Player;
import fr.p10.miage.rps.model.RPSEnum;
import fr.p10.miage.rps.model.Result;
import fr.p10.miage.rps.model.RockPaperScissors;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by yablanch on 14/09/2015.
 * Test {@Link RockPaperScissors}
 */
public class RockPaperScissorsTest extends RockPaperScissors {
    private RockPaperScissors rps;
    private Player p1,p2,p3,p4,p5,p6;
    private List<RPSEnum> ListMouvement1 = new ArrayList<>();
    private List<RPSEnum> ListMouvement2 = new ArrayList<>();
    private List<RPSEnum> ListMouvement3 = new ArrayList<>();
    private List<RPSEnum> ListMouvement4 = new ArrayList<>();
    private List<RPSEnum> ListMouvement5 = new ArrayList<>();
    private List<RPSEnum> ListMouvement6 = new ArrayList<>();

    @BeforeClass

    public void setUp() throws Exception {
        rps = new RockPaperScissors();
    }


    @BeforeClass
    public void setUpClass() throws Exception{
        rps = new RockPaperScissors();
        ListMouvement1.add(RPSEnum.ROCK);
        ListMouvement1.add(RPSEnum.PAPER);
        ListMouvement1.add(RPSEnum.SCISSORS);
        ListMouvement2.add(RPSEnum.SCISSORS);
        ListMouvement2.add(RPSEnum.ROCK);
        ListMouvement2.add(RPSEnum.PAPER);

        ListMouvement4.add(RPSEnum.ROCK);
        ListMouvement4.add(RPSEnum.PAPER);
        ListMouvement4.add(RPSEnum.SCISSORS);
        ListMouvement3.add(RPSEnum.SCISSORS);
        ListMouvement3.add(RPSEnum.ROCK);
        ListMouvement3.add(RPSEnum.PAPER);

        ListMouvement5.add(RPSEnum.ROCK);
        ListMouvement5.add(RPSEnum.PAPER);
        ListMouvement5.add(RPSEnum.SCISSORS);
        ListMouvement6.add(RPSEnum.ROCK);
        ListMouvement6.add(RPSEnum.PAPER);
        ListMouvement6.add(RPSEnum.SCISSORS);

        p1 = new Player("p1",ListMouvement1);
        p2 = new Player("p2",ListMouvement2);

        p3 = new Player("p3",ListMouvement3);
        p4 = new Player("p4",ListMouvement4);

        p5 = new Player("p5",ListMouvement5);
        p6 = new Player("p6",ListMouvement6);
    }

    @AfterClass
    public void tearDown() throws Exception {
        rps = null;
        ListMouvement1 = null;
        ListMouvement2 = null;
        ListMouvement3 = null;
        ListMouvement4 = null;
        ListMouvement5 = null;
        ListMouvement6 = null;
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
        p5 = null;
        p6 = null;
    }


    @DataProvider(name = "WinData")
    public Object[][] createWinData() {
        return new Object[][]{
                {"PAPER", "ROCK"},
                {"SCISSORS", "PAPER"},
                {"ROCK", "SCISSORS"}
        };
    }

    @DataProvider(name = "LostData")
    public Object[][] createLossData() {
        return new Object[][]{
                {"ROCK", "PAPER"},
                {"PAPER", "SCISSORS"},
                {"SCISSORS", "ROCK"}
        };
    }

    @DataProvider(name = "TieData")
    public Object[][] createTieData() {
        return new Object[][]{
                {"ROCK", "ROCK"},
                {"PAPER", "PAPER"},
                {"SCISSORS", "SCISSORS"}
        };
    }



    @Test(dataProvider = "WinData")
    public void testWinPlay(String p1,String p2) throws Exception {
         assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.WIN);

    }

    @Test(dataProvider = "LostData")
    public void testLostPlay(String p1,String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.LOST);

    }

    @Test(dataProvider = "TieData")
    public void testTiePlay(String p1,String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.TIE);

    }

    @Test
    public void testPlayer1Win() throws Exception {
        assertEquals(rps.play(p1,p2),Result.WIN);
        assertEquals(p1.getScore(),3);
        assertEquals(p2.getScore(),0);
    }

    @Test
    public void testPlayer2Win() throws Exception {
        assertEquals(rps.play(p3, p4),Result.LOST);
        assertEquals(p3.getScore(),0);
        assertEquals(p4.getScore(),3);
    }

    @Test
    public void testPlayerTie() throws Exception {
        assertEquals(rps.play(p5, p6),Result.TIE);
        assertEquals(p5.getScore(),3);
        assertEquals(p6.getScore(),3);
    }

}

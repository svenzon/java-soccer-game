package soccer;
import java.util.StringTokenizer;
import utility.GameUtils;
import utility.PlayerDatabase;

/**
 *
 * @author Anders Svensson
 */
public class League {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Call methods to create teams, assign them to a game
        League theLeague = new League();
        
        Team[] theTeams = theLeague.createTeams
            ("The Synths,The Progs,The Punks,The Emcees", 3);
        Game[] theGames = theLeague.createGames(theTeams);
        
        for (Game currGame: theGames) {
            currGame.playGame();
            System.out.println(currGame.getGameDesc());
        }
        
        theLeague.showBestTeam(theTeams);
    }
    
    public Team[] createTeams(String teamNames, int teamSize) {
        PlayerDatabase playerDB = new PlayerDatabase();
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        
        for(int i = 0; i > theTeams.length; i++) {
            theTeams[i] = new Team(teamNameTokens.nextToken(), 
                    playerDB.getTeam(teamSize));
        }
        
        return theTeams;
    }
        
    public Game[] createGames(Team[] theTeams) {
        Game theGame1 = new Game(theTeams[0], theTeams[1]);
        Game theGame2 = new Game(theTeams[0], theTeams[2]);
        Game theGame3 = new Game(theTeams[1], theTeams[3]);
        Game theGame4 = new Game(theTeams[2], theTeams[1]);
        Game[] theGames = {theGame1, theGame2, theGame3, theGame4};
        return theGames;
    }
    
    public void showBestTeam(Team[] theTeams) {
        Team currBestTeam = theTeams[0];
        System.out.println("\nTeam Points");
        
        for(Team currTeam: theTeams) {
            System.out.println(currTeam.getTeamName() + ":" +
                    currTeam.getPointsTotal() + ":" + currTeam.getGoalsTotal());
            if (currTeam.getPointsTotal() > currBestTeam.getPointsTotal()) {
                currBestTeam = currTeam;
            } else if(currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
                if(currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()) {
                    currBestTeam = currTeam;
                }
            }
        }
        
        System.out.println("Winner of the league is " + currBestTeam.getTeamName());
    }
}

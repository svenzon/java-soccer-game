package soccer;
import java.util.*;
import java.time.*;
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
        
        Team[] theTeams = theLeague.createTeams("The Synths,The Progs,The Punks,The Emcees", 3);
        Game[] theGames = theLeague.createGames(theTeams);
        
        System.out.println(theLeague.getLeagueAnnouncement(theGames));
        
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
        
        for(int i = 0; i < theTeams.length; i++) {
            theTeams[i] = new Team(teamNameTokens.nextToken(), 
                    playerDB.getTeam(teamSize));
        }
        
        return theTeams;
    }
        
    public Game[] createGames(Team[] theTeams) {
        int daysBetweenGames = 0;
        
        ArrayList<Game> theGames = new ArrayList();
        
        for(Team homeTeam: theTeams) {
            for(Team awayTeam: theTeams) {
                if (homeTeam!=awayTeam) {
                    theGames.add(new Game(homeTeam, awayTeam, 
                            LocalDateTime.now().plusDays(daysBetweenGames)));
                    daysBetweenGames += 7;
                }
            }
        }
        
        return (Game[]) theGames.toArray(new Game[1]);
    }
    
    public void showBestTeam(Team[] theTeams) {
        Arrays.sort(theTeams);
        
        Team currBestTeam = theTeams[0];
        System.out.println("\nTeam Points");
        
        for(Team currTeam: theTeams) {
            System.out.println(currTeam.getTeamName() + ":" +
                    currTeam.getPointsTotal() + ":" + currTeam.getGoalsTotal());
        }
        
        System.out.println("Winner of the league is " + currBestTeam.getTeamName());
    }
    
    public String getLeagueAnnouncement (Game[] theGames) {
        Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(),
                theGames[theGames.length - 1].getTheDateTime().toLocalDate());
        return "The League is scheduled to run for " + thePeriod.getMonths() +
                " month(s), and " + thePeriod.getDays() + " day(s).\n";
    }
}

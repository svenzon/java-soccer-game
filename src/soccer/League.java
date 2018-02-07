package soccer;
import utility.GameUtils;

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
        Team[] theTeams = createTeams();
        Game[] theGames = createGames(theTeams);
        Game currGame = theGames[0];
        currGame.playGame();
        
        System.out.println(currGame.getGameDesc());
        
        //Print the scoring player's catchphrase
        //game1.goals[0].thePlayer.sayCatchphrase();
    }
    
    public static Team[] createTeams() {
        // Create first team and place players in array
        Team team1 = new Team();
        team1.teamName = "The Synths";
        team1.playerArray = new Player[3];
        team1.playerArray[0] = new Player("Dave Gahan", "I'll make you a believer");
        team1.playerArray[1] = new Player("Liz Enthusiasm", "I just wanna rock");
        team1.playerArray[2] = new Player("Karin Dreijer", "Pass this on, won't you");

        //Create second team and populate array with players
        Team team2 = new Team();
        team2.teamName = "The Punks";
        team2.playerArray = new Player[3];
        team2.playerArray[0] = new Player("Jello Biafra", "California uber alles");
        team2.playerArray[1] = new Player("Poly Styrene", "Up yours");
        team2.playerArray[2] = new Player("Kim Gordon", "Incinerate");

        //Third team
        Team team3 = new Team();
        team3.teamName = "The Progs";
        team3.playerArray = new Player[3];
        team3.playerArray[0] = new Player("Robert Fripp", "Black rack barbed wire");
        team3.playerArray[1] = new Player("Keith Emerson", "(Pipe organ solo)");
        team3.playerArray[2] = new Player("Jon Anderson", "I'll be the roundabout");

        //Fourth team
        Team team4 = new Team();
        team4.teamName = "The Emcees";
        team4.playerArray = new Player[3];
        team4.playerArray[0] = new Player("Erykah Badu", "");
        team4.playerArray[1] = new Player("Kendrick Lamar", "Don't kill my vibe");
        team4.playerArray[2] = new Player("Mike Eagle", "I'm giant");
            
        Team [] theTeams = {team1, team2, team3, team4};
        return theTeams;
    }
        
    public static Game[] createGames(Team[] theTeams) {
        Game theGame = new Game();
        theGame.homeTeam = theTeams[0];
        theGame.awayTeam = theTeams[1];
        Game[] theGames = {theGame};
            
        return theGames;
    }
}

//        for(Player thePlayer: team2.playerArray) {
//            if(thePlayer.playerName.matches(".*K.*")){
//                System.out.println("Found player "
//                        + thePlayer.playerName.split(" ")[1] + ", "
//                        + thePlayer.playerName.split(" ")[0]);
//            }
//        }
        
//        StringBuilder familyNameFirst = new StringBuilder();
//        
//        for (Player thePlayer: team1.playerArray) {
//            String name[] = thePlayer.playerName.split(" ");
//            familyNameFirst.append(name[1]);
//            familyNameFirst.append(", ");
//            familyNameFirst.append(name[0]);
//            System.out.println(familyNameFirst);
//            familyNameFirst.delete(0, familyNameFirst.length());
//        }
        
//        //Create games with one home and one away team
//        Game game1 = new Game();
//        game1.homeTeam = team4;
//        game1.awayTeam = team1;
//        
//        Game game2 = new Game();
//        game2.homeTeam = team3;
//        game2.awayTeam = team2;

//        //Create a new goal, assign scoring player, team and time
//        Goal goal1 = new Goal();
//        goal1.thePlayer = game1.homeTeam.playerArray[2];
//        goal1.theTeam = game1.homeTeam;
//        goal1.theTime = 14;
//        Goal[] theGoals = {goal1};
//        game1.goals = theGoals;

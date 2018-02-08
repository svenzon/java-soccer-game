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
        League theLeague = new League();
        
        Team[] theTeams = theLeague.createTeams();
        Game[] theGames = theLeague.createGames(theTeams);
        
        for (Game currGame: theGames) {
            currGame.playGame();
            System.out.println(currGame.getGameDesc());
        }
        
        theLeague.showBestTeam(theTeams);
    }
    
    public Team[] createTeams() {
        // Create first team and place players in array
        Team team1 = new Team("The Synths");
        team1.setPlayerArray(new Player[3]);
        team1.getPlayerArray()[0] = new Player("Dave Gahan", "I'll make you a believer");
        team1.getPlayerArray()[1] = new Player("Liz Enthusiasm", "I just wanna rock");
        team1.getPlayerArray()[2] = new Player("Karin Dreijer", "Pass this on, won't you");

        //Create second team and populate array with players
        Team team2 = new Team("The Punks");
        team2.setPlayerArray(new Player[3]);
        team2.getPlayerArray()[0] = new Player("Jello Biafra", "California uber alles");
        team2.getPlayerArray()[1] = new Player("Poly Styrene", "Up yours");
        team2.getPlayerArray()[2] = new Player("Kim Gordon", "Incinerate");

        //Third team
        Team team3 = new Team("The Progs");
        team3.setPlayerArray(new Player[3]);
        team3.getPlayerArray()[0] = new Player("Robert Fripp", "Black rack barbed wire");
        team3.getPlayerArray()[1] = new Player("Keith Emerson", "(Pipe organ solo)");
        team3.getPlayerArray()[2] = new Player("Jon Anderson", "I'll be the roundabout");

        //Fourth team
        Team team4 = new Team("The Emcees");
        team4.setPlayerArray(new Player[3]);
        team4.getPlayerArray()[0] = new Player("Erykah Badu", "Don't believe everything you think");
        team4.getPlayerArray()[1] = new Player("Kendrick Lamar", "Don't kill my vibe");
        team4.getPlayerArray()[2] = new Player("Mike Eagle", "I'm giant");
            
        Team [] theTeams = {team1, team2, team3, team4};
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
            System.out.println(currTeam.getTeamName() + ": " +
                    currTeam.getPointsTotal());
            currBestTeam = currTeam.getPointsTotal() >
                    currBestTeam.getPointsTotal() ? currTeam: currBestTeam;
        }
        
        System.out.println("Winner of the league is " 
                + currBestTeam.getTeamName());
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

/*
 * No license in particular. Do what you like.
 */
package utility;

import java.util.*;
import soccer.Player;

/**
 *
 * @author Anders Svensson
 */
public class PlayerDatabase {
    
    private ArrayList<Player> players;
    
    public PlayerDatabase() {
        
        StringTokenizer playerTokens = new StringTokenizer(playerList, ",");
        players = new ArrayList();
        
        while(playerTokens.hasMoreTokens()) {
            players.add(new Player(playerTokens.nextToken()));
        }
    }
    
    public Player[] getTeam(int numberOfPlayers) throws PlayerDatabaseException {
        Player[] teamPlayers = new Player[numberOfPlayers];
        
        for(int i = 0; i < numberOfPlayers; i++) {
            int playerIndex = (int) (Math.random() * players.size());
            
            try {
                teamPlayers[i] = players.get(playerIndex);
                players.remove(playerIndex);
            } catch (IndexOutOfBoundsException ie) {
                throw new PlayerDatabaseException("Not enough players!");
            }
        }
        
        return teamPlayers;
    }
    
    String playerList =
        "Dave Gahan," + 
        "Liz Enthusiasm," + 
        "Karin Dreijer," + 
        "Jello Biafra," + 
        "Poly Styrene," + 
        "Kim Gordon," +
        "Robert Fripp," +
        "Keith Emerson," + 
        "Jon Anderson," +
        "Erykah Badu," + 
        "Kendrick Lamar," +
        "Mike Eagle";
}

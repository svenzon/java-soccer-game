package soccer;

/**
 *
 * @author Anders Svensson
 */
public class Player {
    
    private String playerName;
    private String catchPhrase;
    
    public Player(String playerName /*String catchPhrase*/) {
        this.playerName = playerName;
        //this.catchPhrase = catchPhrase;
    }
    
    public Player() {
        
    }
    
    public void sayCatchphrase() {
        if(getCatchPhrase().length() > 0) {
            System.out.println('"' + getCatchPhrase() + '!' + '"');
        } else {
            System.out.println("!");
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }
}
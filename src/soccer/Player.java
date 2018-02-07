package soccer;

/**
 *
 * @author Anders Svensson
 */
public class Player {
    
    public String playerName;
    public String catchPhrase;
    
    public Player(String name, String phrase) {
        this.playerName = name;
        this.catchPhrase = phrase;
    }
    
    public void sayCatchphrase() {
        if(catchPhrase.length() > 0) {
            System.out.println('"' + catchPhrase + '!' + '"');
        } else {
            System.out.println("!");
        }
    }
}
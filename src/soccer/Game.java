package soccer;

import utility.GameUtils;

/**
 *
 * @author Anders Svensson
 */
public class Game {
    
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;
    
    public Game (Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    
    void playGame(int maxGoals) {
        int numberOfGoals = (int)(Math.random() * (maxGoals + 1));
        
        Goal[] theGoals = new Goal[numberOfGoals];
        this.setGoals(theGoals);
        
        GameUtils.addGameGoals(this);
    }
    
    public void playGame() {
        playGame(6);
    }
    
    public String getGameDesc () {
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        
        StringBuilder gameDesc = new StringBuilder();
        
        //Show which teams are currently playing
        gameDesc.append(homeTeam.getTeamName() + " vs. " 
                + awayTeam.getTeamName() + "\n");
        
        for(Goal currGoal: this.getGoals()) {
            
            //Check who scored and add to score variable
            if (currGoal.getTheTeam() == homeTeam) {
                homeTeamGoals++;
            } else {
                awayTeamGoals++;
            }
            
            //Print score time, scoring player and their team name
            gameDesc.append("Goal scored after " + currGoal.getTheTime() +
                        " mins by " + currGoal.getThePlayer().getPlayerName() +
                        " of " + currGoal.getTheTeam().getTeamName() + "!\n");
        }
        
        //Print the match results
        if(homeTeamGoals == awayTeamGoals) {
            gameDesc.append("The game ended in a draw!");
            homeTeam.incPointsTotal(1);
            awayTeam.incPointsTotal(1);
        } else if(homeTeamGoals > awayTeamGoals) {
            gameDesc.append(gameDesc.append(homeTeam.getTeamName() + " win!"));
            homeTeam.incPointsTotal(2);
        } else {
            gameDesc.append(gameDesc.append(awayTeam.getTeamName() + " win!"));
            awayTeam.incPointsTotal(2);
        }
        
        gameDesc.append(" ("+ homeTeamGoals + " - " + awayTeamGoals + ") \n");
        
        //Convert message to String and return it
        return gameDesc.toString();
    }

    /**
     * @return the homeTeam
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * @param homeTeam the homeTeam to set
     */
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * @return the awayTeam
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * @param awayTeam the awayTeam to set
     */
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * @return the goals
     */
    public Goal[] getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }
}
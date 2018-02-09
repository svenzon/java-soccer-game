package soccer;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Anders Svensson
 */
public class Game {
    
    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] goals;
    private LocalDateTime theDateTime;
    
    public Game (Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = theDateTime;
    }
    
    public void playGame() {
        
        ArrayList<GameEvent> eventList = new ArrayList();
        GameEvent currEvent;
        
        for(int i = 1; i <= 90; i++) {
            if(Math.random() > 0.8) {
                //System.out.println(i);
                currEvent = Math.random() > 0.8 ? new Goal() : new Possession();
                currEvent.setTheTeam(Math.random() > 0.5 ? homeTeam: awayTeam);
                currEvent.setThePlayer(currEvent.getTheTeam().getPlayerArray()
                [(int) (Math.random() * currEvent.getTheTeam().getPlayerArray().length)]);
                currEvent.setTheTime(i);
                eventList.add(currEvent);
            }
        }

        this.goals = new GameEvent[eventList.size()];
        eventList.toArray(goals);
    }
    
    public String getGameDesc () {
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        
        StringBuilder gameDesc = new StringBuilder();
        
        //Show which teams are currently playing
        gameDesc.append(this.getHomeTeam().getTeamName() + " vs. " 
                + this.getAwayTeam().getTeamName() + "\n" +
                "Date: " + this.theDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE)
                + "\n");
         
            for(GameEvent currEvent: this.getEvents()) {

                //Check who scored and add to score variable
                if (currEvent instanceof Goal) {
                    if (currEvent.getTheTeam() == homeTeam) {
                        homeTeamGoals++;
                        homeTeam.incGoalsTotal(1);
                    } else {
                        awayTeamGoals++;
                        awayTeam.incGoalsTotal(1);
                    }
                    
                    currEvent.getThePlayer().incGoalsScored();
                }
                //Print score time, scoring player and their team name
                gameDesc.append(currEvent + " after " + currEvent.getTheTime() + 
                        " mins by " + currEvent.getThePlayer().getPlayerName() + 
                        " of " + currEvent.getTheTeam().getTeamName() + "!\n");
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
    public GameEvent[] getEvents() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setEvents(GameEvent[] goals) {
        this.goals = goals;
    }

    /**
     * @return the theDateTime
     */
    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    /**
     * @param theDateTime the theDateTime to set
     */
    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import utility.GameUtils;

/**
 *
 * @author Anders Svensson
 */
public class Game {
    
    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;
    
    public void playGame() {
        int numberOfGoals = (int)(Math.random() * 7);
        
        Goal[] theGoals = new Goal[numberOfGoals];
        this.goals = theGoals;
        
        GameUtils.addGameGoals(this);
    }
    
    public String getGameDesc () {
        StringBuilder gameDesc = new StringBuilder();
        
        for(Goal currGoal: this.goals) {
            gameDesc.append("Goal scored after " + currGoal.theTime +
                        " mins by " + currGoal.thePlayer.playerName +
                        " of " + currGoal.theTeam.teamName + "!\n");
        }
        
        return gameDesc.toString();
    }
}
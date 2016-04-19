/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiantwarsrun;

import aiantwars.IAntWarsPlayer;
import java.util.Collection;

/**
 *
 * @author Tobias Grundtvig
 */
public class TestLoader
{
    public static void main(String[] args)
    {
        Loader loader = new Loader("C:/tmp");
        Collection<IAntWarsPlayer> players = loader.loadCategory("A", 10);
        
        System.out.println(players.size() + " players loaded:");
        for(IAntWarsPlayer player : players)
        {
            System.out.println("Player: " + player.getTeamName());
        }
    }
}

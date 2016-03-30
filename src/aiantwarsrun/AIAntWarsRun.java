/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiantwarsrun;

import aiantwars.IAntAI;
import aiantwars.impl.Board;
import aiantwars.impl.Location;
import aiantwars.impl.SimpleAI;
import aiantwarsgraphics.AIAntWarsApp;
import app2dapi.Platform;
import app2dapi.panandzoom2dapp.PanAndZoom2DApp;
import app2dapi.panandzoom2dapp.PanAndZoomAdapter;
import app2dpcimpl.PCPlatformImpl;
import java.util.Random;


/**
 *
 * @author Tobias Grundtvig
 */
public class AIAntWarsRun
{

    //////////////////////////////////////////////////////////////////////
    // Start up the app
    //////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args)
    {
        Random rnd = new Random();
        int xSize = 6;
        int ySize = 6;
        Board board = new Board(xSize, ySize);
        for(int y = 0; y < ySize; ++y)
        {
            for(int x = 0; x < xSize; ++x)
            {
                Location loc = board.getLocation(x, y);
                loc.setFoodCount(rnd.nextInt(5));
                int tmp = rnd.nextInt(100);
                if(tmp > 80)
                {
                    loc.setFilled(true);
                    if(tmp > 95)
                    {
                        loc.setRock(true);
                    }
                }
            }
        }
        
        //Clear board for starting pos
        startLocation(board.getLocation(0, 0));       
        startLocation(board.getLocation(0, 1));
        startLocation(board.getLocation(1, 0));
        
        startLocation(board.getLocation(board.getSizeX()-1, board.getSizeY()-1));
        startLocation(board.getLocation(board.getSizeX()-2, board.getSizeY()-1));
        startLocation(board.getLocation(board.getSizeX()-1, board.getSizeY()-2));
        
        
        startLocation(board.getLocation(0, board.getSizeY()-1));
        startLocation(board.getLocation(1, board.getSizeY()-1));
        startLocation(board.getLocation(0, board.getSizeY()-2));
        
        startLocation(board.getLocation(board.getSizeX()-1, 0));
        startLocation(board.getLocation(board.getSizeX()-2, 0));
        startLocation(board.getLocation(board.getSizeX()-1, 1));
        
        IAntAI[] ais = new IAntAI[4];
        ais[0] = new SimpleAI(); //RED
        ais[1] = new SimpleAI(); //BLUE
        ais[2] = new SimpleAI();  //GREEN
        ais[3] = new SimpleAI(); //YELLOW
        
        Platform p = new PCPlatformImpl(true);
        PanAndZoom2DApp app = new AIAntWarsApp(board, ais);
        p.runApplication(new PanAndZoomAdapter(app));
    }
    
    static void startLocation(Location loc)
    {
        loc.setRock(false);
        loc.setFilled(false);
        loc.setFoodCount(5);
    }
    
}

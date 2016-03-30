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
public class AIAntWarsRun2
{

    //////////////////////////////////////////////////////////////////////
    // Start up the app
    //////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args)
    {
        Board board = new Board(200, 200);
        for(int y = 0; y < 2; ++y)
        {
            for(int x = 0; x < 2; ++x)
            {
                Location loc = board.getLocation(x, y);
                loc.setFoodCount(20);
            }
        }
       
        IAntAI[] ais = new IAntAI[4];
        ais[0] = new SimpleAI(); //RED
        ais[1] = new SimpleAI(); //BLUE
        ais[2] = new SimpleAI();  //GREEN
        ais[3] = new SimpleAI(); //YELLOW
        
        Platform p = new PCPlatformImpl(true);
        PanAndZoom2DApp app = new AIAntWarsApp(board, ais);
        p.runApplication(new PanAndZoomAdapter(app));
    }
}

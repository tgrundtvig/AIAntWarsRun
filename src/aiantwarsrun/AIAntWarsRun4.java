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
import aiantwarsgraphics.BoardPos;
import app2dapi.Platform;
import app2dapi.panandzoom2dapp.PanAndZoom2DApp;
import app2dapi.panandzoom2dapp.PanAndZoomAdapter;
import app2dpcimpl.PCPlatformImpl;


/**
 *
 * @author Tobias Grundtvig
 */
public class AIAntWarsRun4
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
        
        BoardPos[] positions = new BoardPos[4];
        positions[0] = new BoardPos(0, 0, 0);
        positions[1] = new BoardPos(board.getSizeX()-1, board.getSizeY()-1, 2);
        positions[2] = new BoardPos(0, board.getSizeY()-1, 1);
        positions[3] = new BoardPos(board.getSizeX()-1, 0, 3);
        
        Platform p = new PCPlatformImpl(true);
        PanAndZoom2DApp app = new AIAntWarsApp(board, ais, positions);
        p.runApplication(new PanAndZoomAdapter(app));
    }
}

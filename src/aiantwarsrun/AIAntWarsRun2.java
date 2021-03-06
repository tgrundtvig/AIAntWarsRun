/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiantwarsrun;

import aiantwars.EAntType;
import aiantwars.IAntAI;
import aiantwars.impl.AntWarsGameCtrl;
import aiantwars.impl.Board;
import aiantwars.impl.DummyGraphicsAntWarsGUI;
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
public class AIAntWarsRun2
{

    //////////////////////////////////////////////////////////////////////
    // Start up the app
    //////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args)
    {
        Board board = BoardBuilder.buildTwoPlayerSymmetric(32, 17, 16, 4, 0, 4, 5);
       
        IAntAI[] ais = new IAntAI[2];
        ais[0] = new SimpleAI(); //RED
        ais[1] = new SimpleAI(); //BLUE
        
        
        int yA = board.getSizeY() / 2;
        int yB = board.getSizeY() % 2 == 0 ? yA - 1 : yA;
        
        BoardPos[] positions = new BoardPos[2];
        positions[0] = new BoardPos(0, yA, 1);
        positions[1] = new BoardPos(board.getSizeX() - 1, yB, 3);
        
        Platform p = new PCPlatformImpl(true);
        PanAndZoom2DApp app = new AIAntWarsApp(board, ais, positions);
        p.runApplication(new PanAndZoomAdapter(app));
    }
}

package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* @brief   Main Program
 * @file    Main.java
 * @author  Javier Serrano Casas
 * @date    01-05-2018
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.net.URISyntaxException
     */
    public static void main(String[] args) throws URISyntaxException {
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        
        Dice.createInstance(napakalakiView);
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);

        ArrayList<String> names = namesCapture.getNames();
       
        Napakalaki.getInstance().initGame(names);
        Napakalaki.getInstance().getSound(0).loop();
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView(args); 
    }
}
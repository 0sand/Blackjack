package com.sand.count21;
import com.sand.count21.logiikka.Game;
import com.sand.count21.ui.GUI;

/**
 * The main class of the Blackjack game.
 * @author osand
 */
public class Main {

    /**
     * The main method of the game Blackjack.
     * @param args Main args
     */
    public static void main(String[] args) {
        Game game = new Game();
        GUI gui = new GUI(game);        
        gui.display();
    }
}

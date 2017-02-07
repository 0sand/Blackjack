package com.sand.count21;


import com.sand.count21.logiikka.Game;
import com.sand.count21.ui.GUI;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        GUI gui = new GUI(game);
        gui.display();

    }

}

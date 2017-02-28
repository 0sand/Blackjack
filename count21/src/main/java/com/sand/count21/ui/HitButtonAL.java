package com.sand.count21.ui;

import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Game;
import com.sand.count21.logiikka.Player;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author osand
 */
public class HitButtonAL implements ActionListener {

    private Game game;
    private GUI gui;
    private ImageGetter imageGetter;
    private JComponent playerPanel;

    public HitButtonAL(Game game, GUI gui, ImageGetter imageGetter) {
        this.game = game;
        this.gui = gui;
        this.imageGetter = imageGetter;
        this.playerPanel = gui.getPlayerPanel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getCounter().addToCounter();
        int i = gui.getCounter().getCounterValue();
        int moveCard = 120;
        Player player = game.getPlayer();
        if (!game.checkIfBust(player)) {
            game.dealTo(player, 1);
            Card card = player.getLastCard();
            Image image = imageGetter.getCardImage(card);
            ImageIcon icon = new ImageIcon(image);
            JLabel playerCardHit = new JLabel(icon);

            playerCardHit.setBounds(130 + (moveCard * (i)), 15,
                    icon.getIconWidth(),
                    icon.getIconHeight());
            playerPanel.add(playerCardHit, new Integer(i+1));

            gui.getPlayerPanel().revalidate();
        }

        if (game.checkIfBust(player)) {

            gui.getHitButton().setEnabled(false);
            for (ActionListener a : gui.getStayButton().getActionListeners()) {
                a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {
                    //Nothing need go here, the actionPerformed method (with the
                    //above arguments) will trigger the respective listener
                });
            }
        }
    }

}

package com.sand.count21.ui;

import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Game;
import com.sand.count21.logiikka.Player;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

/**
 *
 * @author osand
 */
public class DealButtonAL implements java.awt.event.ActionListener {

    private final int firstCardXvalue;
    private final int nextCardXOffset;
    Timer timer;
    Game game;
    GUI gui;
    ImageGetter imageGetter;

    public DealButtonAL(Game game, GUI gui, ImageGetter imageGetter) {
        this.nextCardXOffset = 115;
        this.firstCardXvalue = 20;
        this.game = game;
        this.gui = gui;
        this.imageGetter = imageGetter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer = new Timer(100, new AnimatorAL(game, gui));
        game.startNewRound();
        
        this.clearTheTable();
        this.activateTheCorrectButtons();
        this.updateTheInfoField();
        ArrayList<ImageIcon> icons = this.getIconsForPlayerInitialCards(this.game.getPlayer(), "player");
        this.showInitialCards(icons, this.gui.getPlayerPanel());
        icons = this.getIconsForPlayerInitialCards(this.game.getDealer(), "dealer");
        this.showInitialCards(icons, this.gui.getDealerPanel());

  
        Player player = game.getPlayer();
        if (game.checkIfSumIs21(player)) {
            gui.getHitButton().setEnabled(false);
        }
        gui.getInfoField().setText("");
    }

    private ArrayList<ImageIcon> getIconsForPlayerInitialCards(Player player, String id) {
        ArrayList<Card> cards = player.getCards();
        ImageIcon icon = imageGetter.getCardIcon(cards.get(0));
        ImageIcon icon2 = null;
        if ("player".equals(id)) {
            icon2 = imageGetter.getCardIcon(cards.get(1));
        } else if ("dealer".equals(id)) {
            icon2 = imageGetter.getIcon("images/backcard.png");
        }     
        ArrayList<ImageIcon> icons = new ArrayList();
        icons.add(icon);
        icons.add(icon2);
        return icons;
    }

    private void showInitialCards(ArrayList<ImageIcon> icons, JComponent panel) {
        int i = 0;
        for (ImageIcon icon : icons) {
            JLabel card = new JLabel(icon);
            card.setBounds((firstCardXvalue + nextCardXOffset * i), 15,
                    icon.getIconWidth(),
                    icon.getIconHeight());
            panel.add(card, new Integer(i));  
            i++;
        }
    }

    private void updateTheInfoField() {
        gui.getPlayerMoneyField().setText("Money " + game.getPlayer().getMoney());
        gui.getGamesPlayed().setText("Games played " + game.getPlayer().getGamesPlayed());
        gui.getInfoField().repaint();
    }

    private void activateTheCorrectButtons() {
        gui.getDecreaseBetButton().setEnabled(false);
        gui.getBetButton().setEnabled(false);
        gui.getAgainButton().setEnabled(false);
        gui.getStayButton().setEnabled(true);
        gui.getHitButton().setEnabled(true);
    }

    private void clearTheTable() {
        gui.getPlayerPanel().removeAll();
        gui.getPlayerPanel().repaint();
        gui.getDealerPanel().removeAll();
        gui.getDealerPanel().repaint();
    }

}

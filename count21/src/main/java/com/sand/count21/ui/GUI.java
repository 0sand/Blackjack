package com.sand.count21.ui;

import com.sand.count21.logiikka.ImageGetter;
import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Game;
import com.sand.count21.logiikka.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Grafic Interface for the blackjack game. At the moment quit ugly code and
 * needs a lot of work. But hey. The game works.
 *
 * @author osand
 */
public class GUI extends JPanel {

    Game game;
    ImageGetter imageGetter = new ImageGetter();

    JPanel kortit = new JPanel(new BorderLayout());

    JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
    
    
    JPanel dealerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
    JPanel playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
   
    JButton hitButton = new JButton();
    JButton stayButton = new JButton();
    JButton againButton = new JButton();
    JButton increaseBetButton = new JButton();
    JButton decreaseBetButton = new JButton();

    JTextPane numberOfWins = new JTextPane();
    JTextPane currentBetField = new JTextPane();
    JTextPane playerMoneyField = new JTextPane();
    JTextPane infoField = new JTextPane();

    JLabel dealerlabel = new JLabel();
    JLabel playerlabel = new JLabel();
    

    


    
    JLabel dealerCard2;
    JLabel dealerCard1;
    JLabel dealerCardHit;
    JLabel playerCard0;
    JLabel playerCard1;
    JLabel playerCardHit;

    float fontsize = 30;

    public GUI(Game game) {

        this.game = game;
        Font font = UIManager.getFont("Button.font").deriveFont(fontsize);

        dealerPanel.setBackground(new Color(12, 112, 12));
        playerPanel.setBackground(new Color(12, 112, 12));
        bottomPanel.setBackground(new Color(12, 112, 12));
        infoPanel.setBackground(new Color(12, 112, 12));
        
        
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,10));

        hitButton.setText("Hit");
        hitButton.setPreferredSize(new Dimension(120, 80));
        hitButton.setEnabled(false);
        hitButton.setFont(font);

        againButton.setEnabled(true);
        againButton.setPreferredSize(new Dimension(120, 80));
        againButton.setText("Deal");
        againButton.setFont(font);

        stayButton.setText("Stay");
        stayButton.setEnabled(false);
        stayButton.setPreferredSize(new Dimension(120, 80));
        stayButton.setFont(font);

        decreaseBetButton.setFont(font);
        decreaseBetButton.setText("-");
        decreaseBetButton.setEnabled(true);
        decreaseBetButton.setPreferredSize(new Dimension(60, 80));

        increaseBetButton.setFont(font);
        increaseBetButton.setText("+");
        increaseBetButton.setEnabled(true);
        increaseBetButton.setPreferredSize(new Dimension(60, 80));

        numberOfWins.setText("Player Wins  0");
        numberOfWins.setFont(font);
        numberOfWins.setBackground(new Color(12, 112, 12));

        numberOfWins.setEnabled(false);

        currentBetField.setText("bet " + game.getBetManager().getBet());
        currentBetField.setBackground(new Color(12, 112, 12));
        currentBetField.setEnabled(false);
        currentBetField.setFont(font);

        playerMoneyField.setText("Money " + game.getPlayer().getMoney());
        playerMoneyField.setBackground(new Color(12, 112, 12));
        playerMoneyField.setEnabled(false);
        playerMoneyField.setFont(font);

        infoField.setFont(font);
        infoField.setBackground(new Color(12, 112, 12));

        infoField.setEnabled(false);

        hitButton.addActionListener(new HitButtonAL(game, this, imageGetter));
        againButton.addActionListener(new DealButtonAL(game, this, imageGetter));
        stayButton.addActionListener(new StayButtonAL(game, imageGetter, this));
        increaseBetButton.addActionListener(new BetButtonAL(game, this));
        decreaseBetButton.addActionListener(new BetButtonAL(game, this));

        bottomPanel.add(hitButton);
        bottomPanel.add(stayButton);
        bottomPanel.add(againButton);
        bottomPanel.add(decreaseBetButton);
        bottomPanel.add(increaseBetButton);

        infoPanel.add(numberOfWins);
        infoPanel.add(currentBetField);
        infoPanel.add(playerMoneyField);
        infoPanel.add(infoField);

        dealerlabel.setText("  Dealer:  ");
        playerlabel.setText("  Player:  ");

        kortit.add(dealerPanel, BorderLayout.NORTH);
        kortit.add(playerPanel, BorderLayout.CENTER);
        
        
        setLayout(new BorderLayout());
        add(infoPanel, BorderLayout.NORTH);
        add(kortit, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        

 
    }

    public JButton getIncreaseBetButton() {
        return increaseBetButton;
    }

    public JTextPane getInfoField() {
        return infoField;
    }

    public JButton getDecreaseBetButton() {
        return decreaseBetButton;
    }

    public void display() {
        JFrame myFrame = new JFrame("Blackjack");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(this);
        myFrame.setPreferredSize(new Dimension(1500, 1000));
        myFrame.pack();
        myFrame.setVisible(true);

    }

    public JPanel getDealerPanel() {
        return dealerPanel;
    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public JButton getHitButton() {
        return hitButton;
    }

    public JButton getStayButton() {
        return stayButton;
    }

    public JButton getAgainButton() {
        return againButton;
    }

    public JButton getBetButton() {
        return increaseBetButton;
    }

    public JTextPane getNumberOfWins() {
        return numberOfWins;
    }

    public JTextPane getCurrentBetField() {
        return currentBetField;
    }

    public JTextPane getPlayerMoneyField() {
        return playerMoneyField;
    }

    public JLabel getDealerlabel() {
        return dealerlabel;
    }

    public JLabel getPlayerlabel() {
        return playerlabel;
    }

    public JLabel getDealerCard2() {
        return dealerCard2;
    }

    public JLabel getDealerCard1() {
        return dealerCard1;
    }

    public JLabel getDealerCardHit() {
        return dealerCardHit;
    }

    public JLabel getPlayerCard0() {
        return playerCard0;
    }

    public JLabel getPlayerCard1() {
        return playerCard1;
    }

    public JLabel getPlayerCardHit() {
        return playerCardHit;
    }
}

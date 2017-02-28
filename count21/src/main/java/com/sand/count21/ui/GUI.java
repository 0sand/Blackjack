package com.sand.count21.ui;

import com.sand.count21.logiikka.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Graphic Interface for the blackjack game. At the moment quit ugly code and
 * needs a lot of work. But hey. The game works.
 *
 * @author osand
 */
public class GUI extends JPanel {
    Dimension frameDimension;
    Dimension buttonDimension;
    Dimension smallButtonDimension;
    Color color;
    Counter counter;
    JFrame myFrame = new JFrame("Blackjack");
    Game game;
    ImageGetter imageGetter = new ImageGetter();

    JPanel kortit = new JPanel(new BorderLayout());
    JComponent infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
    JComponent dealerPanel = new JLayeredPane();
    JComponent playerPanel = new JLayeredPane();
    JComponent bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JButton hitButton = new JButton();
    JButton stayButton = new JButton();
    JButton againButton = new JButton();
    JButton increaseBetButton = new JButton();
    JButton decreaseBetButton = new JButton();

    JTextPane numberOfWins = new JTextPane();
    JTextPane gamesPlayed = new JTextPane();
    JTextPane currentBetField = new JTextPane();
    JTextPane playerMoneyField = new JTextPane();
    JTextPane infoField = new JTextPane();

    JLabel dealerCard2;
    JLabel dealerCard1;
    JLabel dealerCardHit;
    JLabel playerCard0;
    JLabel playerCard1;
    JLabel playerCardHit;

    float fontsize = 25;

    ActionListener hitButtonAL;

    public GUI(Game game) {
        this.frameDimension = new Dimension(1500, 400);
        this.buttonDimension = new Dimension(120, 80);
        this.smallButtonDimension = new Dimension(60, 80);
        
        this.color = new Color(12, 112, 12);
        this.counter = new Counter();

        playerPanel.setPreferredSize(frameDimension);
        dealerPanel.setPreferredSize(frameDimension);

        this.game = game;
        Font font = UIManager.getFont("Button.font").deriveFont(fontsize);


        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));


        
        hitButton.setPreferredSize(buttonDimension);
        againButton.setPreferredSize(buttonDimension);
        stayButton.setPreferredSize(buttonDimension);
        decreaseBetButton.setPreferredSize(this.smallButtonDimension);
        increaseBetButton.setPreferredSize(this.smallButtonDimension);
        
        hitButton.setEnabled(false);
        againButton.setEnabled(true);
        decreaseBetButton.setEnabled(true);
        stayButton.setEnabled(false);
        increaseBetButton.setEnabled(true);
        numberOfWins.setEnabled(false);
        gamesPlayed.setEnabled(false);
        currentBetField.setEnabled(false);
        playerMoneyField.setEnabled(false);

        infoField.setEnabled(false);
        hitButtonAL = new HitButtonAL(game, this, imageGetter);
        hitButton.addActionListener(hitButtonAL);
        againButton.addActionListener(new DealButtonAL(game, this, imageGetter));
        stayButton.addActionListener(new StayButtonAL(game, imageGetter, this, myFrame));
        increaseBetButton.addActionListener(new BetButtonAL(game, this));
        decreaseBetButton.addActionListener(new BetButtonAL(game, this));

        bottomPanel.add(hitButton);
        bottomPanel.add(stayButton);
        bottomPanel.add(againButton);
        bottomPanel.add(decreaseBetButton);
        bottomPanel.add(increaseBetButton);

        infoPanel.add(numberOfWins);
        infoPanel.add(gamesPlayed);
        infoPanel.add(currentBetField);
        infoPanel.add(playerMoneyField);
        infoPanel.add(infoField);

        kortit.add(dealerPanel, BorderLayout.NORTH);
        kortit.add(playerPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(infoPanel, BorderLayout.NORTH);
        add(kortit, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        this.setGuiElementText();

        bottomPanel.setBackground(color);
        this.changeFont(infoPanel, font);
        this.changeFont(bottomPanel, font);
        this.changeBackground(infoPanel, new Color(20,100,35));
        this.changeBackground(kortit, color);
        
    }

    private void changeFont(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                changeFont(child, font);
            }
        }
    }

    private void changeBackground(Component component, Color color) {
        component.setBackground(color);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                changeBackground(child, color);
            }
        }
    }

    private void setGuiElementText() {
        hitButton.setText("Hit");
        stayButton.setText("Stay");
        againButton.setText("Deal");
        decreaseBetButton.setText("-");
        increaseBetButton.setText("+");
        numberOfWins.setText("Total Wins " + game.getPlayer().getGamesWon());
        gamesPlayed.setText("Games played " + game.getPlayer().getGamesPlayed());
        currentBetField.setText("bet " + game.getBetManager().getBet());
        playerMoneyField.setText("Money " + game.getPlayer().getMoney());
    }

    public Counter getCounter() {
        return counter;
    }

    public JTextPane getGamesPlayed() {
        return gamesPlayed;
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
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(this);
        myFrame.setPreferredSize(new Dimension(1500, 1000));

        myFrame.pack();
        myFrame.setVisible(true);
    }

   
    public JComponent getDealerPanel() {
        return dealerPanel;
    }

    public JComponent getPlayerPanel() {
        return playerPanel;
    }

    public JComponent getBottomPanel() {
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

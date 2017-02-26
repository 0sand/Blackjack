/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author osand
 */
class PaintTest extends JLayeredPane {

    JLabel playerCard0;

    Line2D horizontalLine;

    private final Dimension prefPanelSize = new Dimension(1500, 1000);

    public PaintTest() {

        super();
        setBorder(BorderFactory.createLineBorder(Color.black));

        this.setOpaque(true); // this will make the JPanel transparent 
        // but not its components (JLabel, TextField etc.)
        this.setSize(prefPanelSize);
        horizontalLine = new Line2D.Float(0, 300, prefPanelSize.width, 300);

    }

    @Override
    public Dimension getPreferredSize() {
        return prefPanelSize;
    }

    @Override
    public void paintComponent(Graphics g) {
        int fontSize = 30;
        Font f = new Font("Arial", Font.BOLD, fontSize);
        super.paintComponent(g);

        // Draw Text
        g.setFont(f);
        g.setColor(Color.red);
        g.drawString("BLACKJACK PAYS 3 TO 2", 550, 300);
        g.setColor(Color.black);
        g.drawString("Dealer must draw on 16 and draw to 17", 400, 400);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.draw(horizontalLine);

    }
}

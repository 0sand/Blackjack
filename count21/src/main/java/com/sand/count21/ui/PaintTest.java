/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author osand
 */
class PaintTest extends JPanel {

    public PaintTest() {
        super();
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        this.setOpaque(true); // this will make the JPanel transparent 
        // but not its components (JLabel, TextField etc.)
        this.setLayout(null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        g.drawString("This is my custom Panel!", 10, 20);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.ui;

import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Card;
import static com.sand.count21.logiikka.Suits.*;
import com.sand.count21.ui.GUI;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author osand
 */
public class ImageGetter {


    public ImageGetter() {
        
    }

    public Image getCardImage(Card card) {
        
        String file = card.getFileName();
        Image image = this.getFile(file);
        return image;
    }

    public Image getFile(String filename) {
        Image image = null;
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename);
        try {
            image = ImageIO.read(is);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        image = image.getScaledInstance(250, 363, Image.SCALE_DEFAULT);
        
        return image;
    }
}

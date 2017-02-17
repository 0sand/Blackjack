/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Card;
import static com.sand.count21.logiikka.Suits.*;
import com.sand.count21.ui.GUI;
import com.sand.count21.ui.GUI;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * This class is a helper class for getting the card Images to the GUI.
 * 
 * @author osand
 */
public class ImageGetter {


    /**
     * Constructor for the ImageGetter. Does nothing special right now.
     */
    public ImageGetter() {
        
    }

    /**
     * This method gets the image of the card. 
     * @param card card that needs a image
     * @return the image of the card
     */
    public Image getCardImage(Card card) {
        
        String file = card.getFileName();
        Image image = this.getImage(file);
        return image;
    }

    /**
     * This method gets a image when it is given a filename.
     * @param filename filename for the image wanted
     * @return The image from the filename
     */
    public Image getImage(String filename) {
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

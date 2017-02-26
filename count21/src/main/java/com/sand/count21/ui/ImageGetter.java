package com.sand.count21.ui;

import com.sand.count21.logiikka.Card;
import com.sand.count21.ui.GUI;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * This class is a helper class for getting the card Images to the GUI.
 * 
 * @author osand
 */
public class ImageGetter {

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
    
    public ImageIcon getCardIcon(Card card) {
        Image image = this.getCardImage(card);
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
    
    public ImageIcon getIcon(String filename) {
        Image image = this.getImage(filename);
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
}

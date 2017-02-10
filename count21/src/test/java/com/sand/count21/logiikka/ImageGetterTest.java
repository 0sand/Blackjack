/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import static com.sand.count21.logiikka.Suits.HEARTS;
import java.awt.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author osand
 */
public class ImageGetterTest {

    public ImageGetterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ImageGetterThrowsExceptionIfFileIsNotLoadedProperly() {

        ImageGetter imagegetter = new ImageGetter();
        boolean thrown = false;

        try {
            imagegetter.getImageFromString("dfksjdfk");
        } catch (RuntimeException ex) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void ImageGetterCanGetCardImageWithoutError() {
        boolean thrown = false;
        Card card = new Card(HEARTS, 1);
        ImageGetter imageGetter = new ImageGetter();
        try {
            Image image = imageGetter.getCardImage(card);
        } catch (Exception ex) {
            thrown = true;
        }
        assertFalse(thrown);

    }
    
    @Test
    public void ImageGetterCanNotGetWrongCardImage() {
        boolean thrown = false;
        Card card = new Card(HEARTS, 20);
        ImageGetter imageGetter = new ImageGetter();
        try {
            Image image = imageGetter.getCardImage(card);
        } catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);

    }
}

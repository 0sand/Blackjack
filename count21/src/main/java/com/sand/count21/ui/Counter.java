/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.ui;

/**
 * This class is a helper class that keeps track how many
 * cards has been hited to the player. Used for drawing the cards correctly.
 * 
 */

public class Counter {
    private int counter;

    /**
     * Sets the counter to zero in the constructor.
     */
    public Counter() {
        this.counter = 0;
    }
    /**
     * Adds one to the counter.
     */
    public void addToCounter() {
        this.counter++;
    }
    
    /**
     * zeros the counter.
     */
    public void zeroCounter() {
        this.counter = 0;
    }
    
    /**
     * Gets the counter value.
     * @return the value of the counter
     */
    public int getCounterValue() {
        return this.counter;
    }
}

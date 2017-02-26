/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.ui;



public class Counter {
    private int counter;

    public Counter() {
        this.counter = 0;
    }
    
    public void addToCounter() {
        this.counter++;
    }
    
    public void zeroCounter() {
        this.counter = 0;
    }
    
    public int getCounterValue() {
        return this.counter;
    }
}

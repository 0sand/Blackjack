/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

/**
 * The enum Suits are used for the cards in the game.
 * @author osand
 */
public enum Suits {
    SPADES("S"),
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C");

    private final String name;

    private Suits(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turing.machine;

/**
 *
 * @author Alex "Lexden" Schendel
 */
public class Transition {
    private final char c;
    public Transition(char c){
        this.c = c;
    }

    public char getChar() {
        return c;
    }
}

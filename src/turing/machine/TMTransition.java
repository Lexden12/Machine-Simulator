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
public class TMTransition extends Transition{
    private final TMState dest;
    private final boolean isRight;
    private final char write;
    
    public TMTransition(char c, TMState terminal, boolean right, char w) {
        super(c);
        dest = terminal;
        isRight = right;
        write = w;
    }

    public TMState getDest() {
        return dest;
    }

    public boolean isRight() {
        return isRight;
    }

    public char getWrite() {
        return write;
    }    
}

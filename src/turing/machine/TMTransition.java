/*
 * Copyright (C) 2018 Alex "Lexden" Schendel <lexden.s@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package turing.machine;

/**
 * transition of a Turing Machine
 * @author Alex "Lexden" Schendel
 */
public class TMTransition extends Transition{
    private final TMState dest;
    private final boolean isRight;
    private final char write;
    
    /**
     * constructor for a transition
     * @param c char to read
     * @param terminal next state
     * @param right true means move the head right. Left otherwise
     * @param w char to write
     */
    public TMTransition(char c, TMState terminal, boolean right, char w) {
        super(c);
        dest = terminal;
        isRight = right;
        write = w;
    }

    //getters
    
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

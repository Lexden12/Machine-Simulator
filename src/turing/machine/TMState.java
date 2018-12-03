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

import java.util.ArrayList;

/**
 * a class to store one state of a Turing Machine
 * @author Alex "Lexden" Schendel
 */
public class TMState {
    private String name;
    private ArrayList<TMTransition> transitions;
    int x, y;
    
    /**
     * constructor for the new state.
     * @param name the name of the new state
     */
    public TMState(String name){
        this.name = name;
        transitions = new ArrayList<>();
    }
    
    /**
     * given a character, find out what the next state we should move to is.
     * @param in the character read
     * @return the transition we should follow to get to the proper state
     * returns null if there is no transition on this character
     */
    public TMTransition nextState(char in){
        for(TMTransition t:transitions){
            if(in == t.getChar()){
                return t;
            }
        }
        return null;
    }
    
    /**
     * add a transition to the state
     * @param transition the transition to add
     */
    public void addTransition(TMTransition transition){
        transitions.add(transition);
    }

    //getters
    
    public String getName() {
        return name;
    }

    public ArrayList<TMTransition> getTransitions() {
        return transitions;
    }
}

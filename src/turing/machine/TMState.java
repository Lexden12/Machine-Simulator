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
 *
 * @author Alex "Lexden" Schendel
 */
public class TMState {
    private String name;
    private ArrayList<TMTransition> transitions;
    int x, y;
    
    public TMState(String name){
        this.name = name;
        transitions = new ArrayList<>();
    }
    
    public TMTransition nextState(char in){
        for(TMTransition t:transitions){
            if(in == t.getChar()){
                return t;
            }
        }
        return null;
    }
    
    public void addTransition(TMTransition transition){
        transitions.add(transition);
    }

    public String getName() {
        return name;
    }

    public ArrayList<TMTransition> getTransitions() {
        return transitions;
    }
}

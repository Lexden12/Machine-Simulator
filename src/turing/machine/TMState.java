/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

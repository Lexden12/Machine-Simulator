/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing.machine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex "Lexden" Schendel
 */
public class TuringMachine {
    private Tape tape;
    private ArrayList<TMState> states;
    private int currentState;
    private boolean accepted;
    
    public TuringMachine(String in){
        File f = new File(in);
        states = new ArrayList<>();
        Scanner s;
        try {
            s = new Scanner(f).useDelimiter(",|\r\n");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            return;
        }
        String line = s.nextLine();
        String[] strings = line.split(",");
        for(String name:strings){
            states.add(new TMState(name));
        }
        line = s.nextLine();
        strings = line.split(",");
        char[] tapeChars = new char[strings.length];
        for(int i = 0; i < strings.length; i++){
            tapeChars[i] = strings[i].charAt(0);
        }
        s.nextLine();
        for(int k = 0; k < tapeChars.length; k++){
            char read = s.next().charAt(0);
            for(int i = 0; i < states.size(); i++){
                String write = s.next();
                String direction = s.next();
                String nextState = s.next();
                if(write.isEmpty() || direction.isEmpty() || nextState.isEmpty())
                    continue;
                TMState next = null;
                for(int l = 0; l < states.size(); l++){
                    if(states.get(l).getName().equals(nextState)){
                        next = states.get(l);
                        break;
                    }
                }
                if(next == null)
                    return;
                if(direction.toLowerCase().contains("r"))
                    states.get(i).addTransition(new TMTransition(read, next, true, write.charAt(0)));
                else
                    states.get(i).addTransition(new TMTransition(read, next, false, write.charAt(0)));
            }
        }
    }
    
    public void start(String in){
        tape = new Tape(in);
        currentState = 0;
    }
    
    /**
     * One step in the Turing Machine.
     * Reads the character at the head,
     * Attempts to find a transition out of the current state on that character.
     * If one is found, write the character specified, move the correct direction,
     * and set the currentState.
     * @return next state the TM will enter. Null if no transition is found.
     */
    public TMState step(){
        if(accepted)
            return states.get(states.size()-1);
        if(currentState == -1)
            return null;
        char read = tape.getHead().getElement();
        TMTransition transition = null;
        for(TMTransition t:states.get(currentState).getTransitions()){
            if(t.getChar() == read){
                transition = t;
            }
        }
        if(transition == null){
            currentState = -1;
            return null;
        }
        tape.writeCharacter(transition.getWrite());
        if(transition.isRight())
            tape.moveRight();
        else
            tape.moveLeft();
        currentState = states.indexOf(transition.getDest());
        if(currentState == states.size()-1)
            accepted = true;
        return transition.getDest();
    }

    public ArrayList<TMState> getStates() {
        return states;
    }
    
    public Tape getTape(){
        return tape;
    }
}
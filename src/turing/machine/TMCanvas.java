/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turing.machine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Alex "Lexden" Schendel
 */
public class TMCanvas extends Canvas{
    private TuringMachine TM;
    ArrayList<TMState> states;
    private final int STATE_SIZE = 100;
    private final int RADIUS = 350;
    private float scale;
    private TMState currentState;
    
    public TMCanvas(TuringMachine TM){
        this.TM = TM;
        states = TM.getStates();
        currentState = states.get(0);
        scale = 1f;
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < states.size(); i++){
            g.setColor(Color.YELLOW);
            if(currentState == states.get(i))
                g.setColor(Color.GREEN);
            int x, y;
            x = getStateX(i);
            y = getStateY(i);
            int size = (int)(STATE_SIZE * scale);
            g.fillOval(x, y, size, size);
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,(int)(30 * scale)));
            g.drawString(states.get(i).getName(), x + size / 2 - (int)((states.get(i).getName().length() * 6) * scale), y + size / 2);
            for(int j = 0; j < states.get(i).getTransitions().size(); j++){
                TMState state2 = states.get(i).getTransitions().get(j).getDest();
                int k = states.indexOf(state2);
                int x2 = getStateX(k);
                int y2 = getStateY(k);
                int x3 = (int)((x2 - x + STATE_SIZE)/2.0) + x;
                int y3 = (int)((y2 - y + STATE_SIZE)/2.0) + y;
                int offSet = STATE_SIZE/2;
                double theta = (i * Math.PI * 2)/states.size();
                g.drawLine(x + offSet, y + offSet, x2 + offSet, y2 + offSet);
                g.drawLine(x3, y3, x3 + (int)(30 * scale * Math.cos(theta - Math.PI/4)), y3 + (int)(30 * scale * Math.sin(theta - Math.PI/4)));
                g.drawLine(x3, y3, x3 + (int)(30 * scale * Math.cos(theta + Math.PI/4)), y3 + (int)(30 * scale * Math.sin(theta + Math.PI/4)));
                if(states.get(i).getTransitions().get(j).isRight())
                    g.drawString(states.get(i).getTransitions().get(j).getChar()+" -> "+states.get(i).getTransitions().get(j).getWrite()+", R", x3, y3);
                else
                    g.drawString(states.get(i).getTransitions().get(j).getChar()+" -> "+states.get(i).getTransitions().get(j).getWrite()+", L", x3, y3);
            }
        }
    }
    
    private int getStateX(int i){
        return (int)(RADIUS * scale * Math.cos((i * Math.PI * 2)/states.size())) + getWidth()*7/16;
    }
    
    private int getStateY(int i){
        return (int)(RADIUS * scale * Math.sin((i * Math.PI * 2)/states.size())) + getHeight()*7/16;
    }
    
    public TMState step(){
        currentState = TM.step();
        repaint();
        return currentState;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}

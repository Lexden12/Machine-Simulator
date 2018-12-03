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

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author Alex "Lexden" Schendel
 */
public class TMCanvas extends Canvas{
    private TuringMachine TM;
    ArrayList<TMState> states;
    private final int STATE_SIZE = 100;
    private final int RADIUS = 300;
    private float scale;
    private TMState currentState;
    private boolean isStart;
    private boolean ended;
    private boolean restart;
    private int clickedState = -1;
    private ArrayList<String> strings;
    
    public TMCanvas(TuringMachine TM){
        this.TM = TM;
        states = TM.getStates();
        currentState = states.get(0);
        scale = 1f;
        this.setVisible(true);
        isStart = true;
        this.addMouseListener(new MouseEventListener());
    }
    
    public TMCanvas(TuringMachine TM, ArrayList<String> inputs){
        this.TM = TM;
        states = TM.getStates();
        currentState = states.get(0);
        scale = 1f;
        this.setVisible(true);
        isStart = true;
        this.addMouseListener(new MouseEventListener());
        strings = inputs;
        TM.start(strings.remove(0));
    }

    @Override
    public void paint(Graphics g) {
        if(isStart){
            for(int i = 0; i < states.size(); i++){
                states.get(i).x = getStateX(i);
                states.get(i).y = getStateY(i);
            }
            isStart = false;
        }
        for(int i = 0; i < states.size(); i++){
            g.setColor(Color.YELLOW);
            if(currentState == states.get(i))
                g.setColor(Color.GREEN);
            int x, y;
            x = states.get(i).x;
            y = states.get(i).y;
            int size = (int)(STATE_SIZE * scale);
            g.fillOval(x, y, size, size);
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,(int)(30 * scale)));
            g.drawString(states.get(i).getName(), x + size / 2 - (int)((states.get(i).getName().length() * 6) * scale), y + size / 2);
            for(int j = 0; j < states.get(i).getTransitions().size(); j++){
                TMState state2 = states.get(i).getTransitions().get(j).getDest();
                int k = states.indexOf(state2);
                int x2 = states.get(k).x;
                int y2 = states.get(k).y;
                int x3 = (int)((x2 - x + STATE_SIZE)/2.0) + x;
                int y3 = (int)((y2 - y + STATE_SIZE)/2.0) + y;
                int offSet = STATE_SIZE/2;
                g.drawLine(x + offSet, y + offSet, x2 + offSet, y2 + offSet);
                if(states.get(i).getTransitions().get(j).isRight())
                    g.drawString(states.get(i).getTransitions().get(j).getChar()+" -> "+states.get(i).getTransitions().get(j).getWrite()+", R", x3, y3);
                else
                    g.drawString(states.get(i).getTransitions().get(j).getChar()+" -> "+states.get(i).getTransitions().get(j).getWrite()+", L", x3, y3);
            }
        }
    }
    
    private int getStateX(int i){
        return (int)(RADIUS * scale * Math.cos((i * Math.PI * 2)/states.size())) + getWidth()/2;
    }
    
    private int getStateY(int i){
        return (int)(RADIUS * scale * Math.sin((i * Math.PI * 2)/states.size())) + getHeight()*7/16;
    }
    
    public TMState step(){
        if(restart && !strings.isEmpty()){
            TM.start(strings.remove(0));
            restart = false;
            currentState = TM.getStates().get(0);
            repaint();
            return currentState;
        }
        if(ended && !strings.isEmpty()){
            ended = false;
            restart = true;
            return currentState;
        }
        currentState = TM.step();
        repaint();
        if(TM.accepted || TM.currentState == -1)
            ended = true;
        return currentState;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
    
    private class MouseEventListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            for(int i = 0; i < states.size(); i++){
                int stateX = states.get(i).x;
                int stateY = states.get(i).y;
                int diffX = Math.abs(x - stateX);
                int diffY = Math.abs(y - stateY);
                if(diffX < 100 && diffY < 100){
                    clickedState = i;
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(clickedState != -1){
                states.get(clickedState).x = e.getX();
                states.get(clickedState).y = e.getY();
            }
            clickedState = -1;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }
}

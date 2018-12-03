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

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Alex "Lexden" Schendel
 */
public class TMGUI extends JFrame{
    private TMCanvas canvas;
    private TuringMachine TM;
    private JButton step;
    private JTextArea text;
    private boolean ended;
    
    public TMGUI(TuringMachine TM){
        this.TM = TM;
        canvas = new TMCanvas(TM);
        init();
    }
    
    public TMGUI(TuringMachine TM, ArrayList<String> inputs){
        this.TM = TM;
        canvas = new TMCanvas(TM, inputs);
        init();
    }
    
    public void init(){
        step = new JButton("Step");
        step.addActionListener(new StepButtonListener());
        step.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,40));
        text = new JTextArea();
        text.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,(40)));
        text.setEditable(false);
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setText(TM.getTape().toString());
        this.setVisible(true);
        update();
    }
    
    public void update(){
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.ipady = 700;
        getContentPane().add(canvas, c);
        c.gridy = 1;
        c.weighty = 0;
        c.ipady = 0;
        getContentPane().add(step, c);
        c.gridy = 2;
        getContentPane().add(text, c);
    }
    
    private class StepButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            TMState state = canvas.step();
            if(ended){
                text.setBackground(Color.white);
                ended = false;
            }
            if(state == TM.getStates().get(TM.getStates().size()-1)){
                text.setBackground(Color.green);
                ended = true;
            }
            else if(state == null){
                text.setBackground(Color.red);
                ended = true;
            }
            text.setText(TM.getTape().toString());
        }
    }
}

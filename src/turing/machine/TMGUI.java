/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turing.machine;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    
    public TMGUI(TuringMachine TM){
        this.TM = TM;
        getContentPane().setLayout(new GridLayout(2,1));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        canvas = new TMCanvas(TM);
        step = new JButton("Step");
        step.addActionListener(new StepButtonListener());
        step.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,40));
        text = new JTextArea();
        text.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,(40)));
        getContentPane().add(canvas);
        panel.add(step);
        panel.add(text);
        getContentPane().add(panel);
        setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setText(TM.getTape().toString());
        this.setVisible(true);
    }
    
    private class StepButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            TMState state = canvas.step();
            if(state == TM.getStates().get(TM.getStates().size()-1)){
                text.setBackground(Color.green);
            }
            else if(state == null){
                text.setBackground(Color.red);
            }
            
            text.setText(TM.getTape().toString());
        }
    }
}

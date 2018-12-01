/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turing.machine;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex "Lexden" Schendel
 */
public class Simulator {
    public static void main(String[] args) {
        String path = "C:\\Users\\alexi\\Documents\\NetBeansProjects\\Turing Machine\\test\\";
        String file = JOptionPane.showInputDialog("Enter the path to the csv to the TM you wish to simulate(for the test files, just enter test1 etc.):");
        TuringMachine TM;
        if(file.contains("\\"))
            TM = new TuringMachine(file);
        else
            TM = new TuringMachine(path+file+".csv");
        String in = JOptionPane.showInputDialog("Enter the string you wish to test:");
        TM.start(in);
        TMGUI g = new TMGUI(TM);
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

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
        String in = JOptionPane.showInputDialog("Enter the string you wish to test or enter the path to the text file:");
        int gui = JOptionPane.showConfirmDialog(null, "Would you like to use the GUI?", "Turing Machine Simulator", JOptionPane.YES_NO_OPTION);
        if(gui == 0){
            if(in.contains("\\") || in.startsWith("test")){
                ArrayList<String> strings = parser(in);
                if(strings == null)
                    return;
                TMGUI g = new TMGUI(TM, strings);
            }
            else{
                TM.start(in);
                TMGUI g = new TMGUI(TM);
            }
        }
        else{
            if(in.contains("\\")){
                ArrayList<String> strings = parser(in);
                if(strings == null)
                    return;
                noGUI(TM, strings);
            }
            else{
                TM.start(in);
                if(noGUI(TM)){
                    JOptionPane.showMessageDialog(null, "Accepting configuration found!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Input was rejected.");
                }
            }
        }
    }
    
    public static ArrayList<String> parser(String file){
        if(file.startsWith("test")){
            String path = "C:\\Users\\alexi\\Documents\\NetBeansProjects\\Turing Machine\\test\\";
            file = path+"input_"+file+".txt";
        }
        File f = new File(file);
        Scanner s;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Fatal error: File not found.", "Turing Machine Simulator", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        ArrayList<String> strings = new ArrayList<String>();
        while(s.hasNext())
            strings.add(s.nextLine());
        return strings;
    }
    
    public static boolean noGUI(TuringMachine TM){
        TM.step();
        if(TM.accepted)
            return true;
        else if(TM.currentState == -1)
            return false;
        return noGUI(TM);
    }
    
    public static void noGUI(TuringMachine TM, ArrayList<String> inputs){
        JTextArea text = new JTextArea();
        text.setEditable(false);
        String out = "Result:\n";
        while(!inputs.isEmpty()){
            String tmp = inputs.remove(0);
            TM.start(tmp);
            out = out.concat(tmp + ":\t");
            if(noGUI(TM))
                out = out.concat("Accepted.\n");
            else
                out = out.concat("Rejected.\n");
        }
        text.setText(out);
        JOptionPane.showMessageDialog(null, text, "Turing Machine Simulator", JOptionPane.INFORMATION_MESSAGE);
    }
}

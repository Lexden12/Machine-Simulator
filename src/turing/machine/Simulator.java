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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Main program file. Gets use input to run the program as desired
 * @author Alex "Lexden" Schendel
 */
public class Simulator {
    private final static String PATH = System.getProperty("user.dir") + "\\testFiles\\";
    
    /**
     * main method, gets input file for TM, input string(s) and whether to use the GUI or not 
     */
    public static void main(String[] args) {
        int help = JOptionPane.showConfirmDialog(null, "Welcome to the Turing Machine simulator! Would you like to read the instructions?", "Turing Machine Simulator", JOptionPane.YES_NO_OPTION);
        String file = "";
        if(help == 0){
            JOptionPane.showMessageDialog(null, "To get started, you will need to get a Turing Machine in the proper format.");
            JOptionPane.showMessageDialog(null, "You can use one of the test files included by simply typing \"test#\" where the \"#\" is the number of the file.");
            JOptionPane.showMessageDialog(null, "You can find more information about the expected format to create your own Turing Machine in the README.");
            file = JOptionPane.showInputDialog("Try entering the path to the TM now:");
        }
        else
            file = JOptionPane.showInputDialog("Enter the path to the csv to the TM you wish to simulate(for the test files, just enter test1 etc.):");
        TuringMachine TM;
        if(file.contains("\\"))
            TM = new TuringMachine(file);
        else
            TM = new TuringMachine(PATH+file+".csv");
        String in;
        if(help == 0){
            JOptionPane.showMessageDialog(null, "Great! Now it's time to test your Turing Machine.");
            JOptionPane.showMessageDialog(null, "To test it, you need to enter a string or a path to a text file.");
            JOptionPane.showMessageDialog(null, "You can also use the test inputs that came with the program by again typing \"test#\" where the \"#\" is the number of the file.");
            in = JOptionPane.showInputDialog("Try entering the test string or path to source file:");
        }
        else
            in = JOptionPane.showInputDialog("Enter the string you wish to test or enter the path to the text file:");
        int gui;
        if(help == 0){
            JOptionPane.showMessageDialog(null, "Lastly, there are two modes you can run this simulator in. GUI (graphics) or no GUI (quick-run).");
            JOptionPane.showMessageDialog(null, "The GUI has nice features such as animating the states and transitions and tape of the Turing Machine as you step through the input string.");
            JOptionPane.showMessageDialog(null, "The no GUI version (quick-run) is designed to immediately run all the inputs to the TM and give you back the results (accept or reject) immediately.");
            gui = JOptionPane.showConfirmDialog(null, "Knowing that, would you like to run it in GUI mode?", "Turing Machine Simulator", JOptionPane.YES_NO_OPTION);
        }
        else
            gui = JOptionPane.showConfirmDialog(null, "Would you like to use the GUI?", "Turing Machine Simulator", JOptionPane.YES_NO_OPTION);
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
            if(in.contains("\\") || in.startsWith("test")){
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
    
    /**
     * if given a path to a file for multiple input strings, parse the file for the strings
     * @param file path to the file to parse
     * @return an ArrayList of all the strings
     */
    public static ArrayList<String> parser(String file){
        if(file.startsWith("test")){
            file = PATH+"input_"+file+".txt";
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
    
    /**
     * noGUI version (quick-run)
     * @param TM Turing Machine to test
     * @return true for accept, false for reject.
     */
    public static boolean noGUI(TuringMachine TM){
        TM.step();
        if(TM.accepted)
            return true;
        else if(TM.currentState == -1)
            return false;
        return noGUI(TM);
    }
    
    /**
     * noGUI version for multiple input strings
     * @param TM Turing Machine to use
     * @param inputs the multiple strings to test
     */
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

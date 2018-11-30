/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turing.machine;

import java.util.Scanner;

/**
 *
 * @author Alex "Lexden" Schendel
 */
public class Simulator {
    public static void main(String[] args) {
        String path = "C:\\Users\\alexi\\Documents\\NetBeansProjects\\Turing Machine\\test\\";
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the path to the csv to the TM you wish to simulate(for the test files, just enter test1 etc.): ");
        String line = s.nextLine();
        TuringMachine TM;
        if(line.contains("\\"))
            TM = new TuringMachine(s.nextLine());
        else
            TM = new TuringMachine(path+line+".csv");
        System.out.print("Enter the string you wish to test: ");
        TM.start(s.nextLine());
        TMGUI g = new TMGUI(TM);
    }
}

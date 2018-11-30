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
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the path to the csv to the TM you wish to simulate: ");
        TuringMachine TM = new TuringMachine(s.nextLine());
        System.out.print("Enter the string you wish to test: ");
        TM.start(s.nextLine());
        TMGUI g = new TMGUI(TM);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing.machine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexi
 */
public class TuringMachineTest {
    TuringMachine TM;
    public TuringMachineTest() {
        TM = new TuringMachine("C:\\Users\\alexi\\Documents\\NetBeansProjects\\Turing Machine\\test\\test1.csv");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class TuringMachine.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        String in = "0110#0110";
        TM.start(in);
    }

    /**
     * Test of step method, of class TuringMachine.
     */
    @Test
    public void testStep() {
        System.out.println("step");
        String in = "0110#0110";
        TM.start(in);
        TMState expResult = TM.getStates().get(1);
        TMState result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(3);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(5);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(6);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(0);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(2);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(4);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(5);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(6);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        result = TM.step();
        assertEquals(expResult, result);
        expResult = TM.getStates().get(0);
        result = TM.step();
        assertEquals(expResult, result);
    }
    
}

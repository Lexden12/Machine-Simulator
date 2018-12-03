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

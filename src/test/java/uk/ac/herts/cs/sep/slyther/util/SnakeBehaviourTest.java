/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import net.gegy1000.slyther.client.SlytherClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class SnakeBehaviourTest {
    
    public SnakeBehaviourTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isActive method, of class SnakeBehaviour.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        SlytherClient client = null;
        SnakeBehaviour instance = new SnakeBehaviourImpl();
        boolean expResult = false;
        boolean result = instance.isActive(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of targetAngle method, of class SnakeBehaviour.
     */
    @Test
    public void testTargetAngle() {
        System.out.println("targetAngle");
        SnakeBehaviour instance = new SnakeBehaviourImpl();
        double expResult = 0.0;
        double result = instance.targetAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of priority method, of class SnakeBehaviour.
     */
    @Test
    public void testPriority() {
        System.out.println("priority");
        SnakeBehaviour instance = new SnakeBehaviourImpl();
        double expResult = 0.0;
        double result = instance.priority();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBoosting method, of class SnakeBehaviour.
     */
    @Test
    public void testIsBoosting() {
        System.out.println("isBoosting");
        SnakeBehaviour instance = new SnakeBehaviourImpl();
        boolean expResult = false;
        boolean result = instance.isBoosting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class SnakeBehaviour.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        SnakeBehaviour other = new FoodBehaviour();
        SnakeBehaviour instance = new SnakeBehaviourImpl();
        int expResult = 0;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    public class SnakeBehaviourImpl extends SnakeBehaviour {

        public boolean isActive(SlytherClient client) {
            return false;
        }

        public double priority() {
            return 0.0;
        }

        public boolean isBoosting() {
            return false;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.orm;

import java.util.ArrayList;
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
public class DBTest {
    
    public DBTest() {
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
     * Test of connectToDB method, of class DB.
     */
    @Test
    public void testConnectToDB() {
        System.out.println("connectToDB");
        DB instance = new DB();
        instance.connectToDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlayerToDB method, of class DB.
     */
    @Test
    public void testAddPlayerToDB() {
        System.out.println("addPlayerToDB");
        DB instance = new DB();
        instance.addPlayerToDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGameSnakeToDB method, of class DB.
     */
    @Test
    public void testAddGameSnakeToDB() {
        System.out.println("addGameSnakeToDB");
        DB instance = new DB();
        instance.addGameSnakeToDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAllGameSnakes method, of class DB.
     */
    @Test
    public void testReadAllGameSnakes() {
        System.out.println("readAllGameSnakes");
        DB instance = new DB();
        instance.readAllGameSnakes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readPlayerSnakes method, of class DB.
     */
    @Test
    public void testReadPlayerSnakes() {
        System.out.println("readPlayerSnakes");
        DB instance = new DB();
        instance.readPlayerSnakes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSnakes method, of class DB.
     */
    @Test
    public void testGetAllSnakes() {
        System.out.println("getAllSnakes");
        DB instance = new DB();
        ArrayList<GameSnake> expResult = null;
        ArrayList<GameSnake> result = instance.getAllSnakes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerSnake method, of class DB.
     */
    @Test
    public void testGetPlayerSnake() {
        System.out.println("getPlayerSnake");
        DB instance = new DB();
        ArrayList<PlayerSnake> expResult = null;
        ArrayList<PlayerSnake> result = instance.getPlayerSnake();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

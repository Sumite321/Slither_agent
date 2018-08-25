/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.client.game.entity.ClientSnake;
import net.gegy1000.slyther.game.Game;
import net.gegy1000.slyther.game.entity.SnakePoint;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 *
 * @author admin
 */
public class NullBehaviourTest {
    
    private NullBehaviour instance;
    private Game game;
    private SlytherClient client;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        ClientSnake player=mock(ClientSnake.class);
        client=mock(SlytherClient.class);
        client.player=player;
        game=mock(Game.class);
        when(game.getSectorSize()).thenReturn(1000);
        when(client.getGameRadius()).thenReturn(1000);
        player.points=new ArrayList<>();
        player.points.add(new SnakePoint(game,14,19));
        instance=new NullBehaviour();
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of targetAngle method, of class NullBehaviour.
     */
    @Test
    public void testTargetAngle() {
        System.out.println("targetAngle1");

        System.out.println(client.player.points);
        double expAngle = Math.PI/4; // 45degrees
        boolean result = instance.isActive(client);
        System.out.println(client.getGameRadius());
        double actual = instance.targetAngle();
            assertEquals(expAngle,actual,0.0001);
            System.out.println("actual is " + actual);
    }
    
        @Test
    public void testTargetAngle1() {
        System.out.println("targetAngle1");

        System.out.println(client.player.points);
        instance.angle = 12.566370614359172;
        double expAngle = Math.PI; 
        double result = instance.targetAngle();
        System.out.println(client.getGameRadius());
            assertEquals(expAngle,result,0.0001);
            System.out.println("actual is " + result);
    }

    /**
     * Test of priority method, of class NullBehaviour.
     */
    @Test
    public void testPriority() {
        System.out.println("priority");
        NullBehaviour instance = new NullBehaviour();
        double expResult = 0.0;
        double result = instance.priority();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code a
    }

    /**
     * Test of isBoosting method, of class NullBehaviour.
     */
    @Test
    public void testIsBoosting() {
        System.out.println("isBoosting");
        NullBehaviour instance = new NullBehaviour();
        boolean expResult = false;
        boolean result = instance.isBoosting();
        assertEquals(expResult, result);
        // TODO review the generated test code a
    }

    /**
     * Test of isActive method, of class NullBehaviour.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        boolean expResult = true;
        boolean result = instance.isActive(client);
        assertEquals(expResult, result);
        // TODO review the generated test code
    }
     
    @Test
    public void testIsActive1() {
        System.out.println("isActive");
        boolean expResult = true;
        boolean result = instance.isActive(client);
        assertEquals(expResult, result);
        // TODO review the generated test code 
    }    
    @Test
    public void testIsActive2() {
        System.out.println("isActive");
        boolean expResult = true;
        boolean result = instance.isActive(client);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class NullBehaviour.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NullBehaviour instance = new NullBehaviour();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of behaviourName method, of class NullBehaviour.
     */
    @Test
    public void testBehaviourName() {
        System.out.println("behaviourName");
        NullBehaviour instance = new NullBehaviour();
        instance.behaviourName();
    }
    
}

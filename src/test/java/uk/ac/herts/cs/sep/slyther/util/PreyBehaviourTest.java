/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import java.util.ArrayList;
import java.util.List;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.client.game.entity.ClientSnake;
import net.gegy1000.slyther.game.Color;
import net.gegy1000.slyther.game.Game;
import net.gegy1000.slyther.game.entity.Prey;
import net.gegy1000.slyther.game.entity.Snake;
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
public class PreyBehaviourTest {
    
    private SnakeBehaviour behaviour;
    private SlytherClient client;
    private Game game;
    private List<Prey<?>> preys;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        ClientSnake player = mock(ClientSnake.class);        
        client = mock(SlytherClient.class);
        client.player = player;
        game = mock(Game.class);
        when(game.getSectorSize()).thenReturn(1000);
        when(client.getGameRadius()).thenReturn(1000);
        player.points = new ArrayList<>();
        player.points.add(new SnakePoint(game, 0, 0));
        preys = new ArrayList<>();
        when(client.getPreys()).thenReturn(preys);        
        behaviour = new PreyBehaviour();
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testIsActive() {
        preys.add(new Prey(game,1,10,10,1,Color.GREEN,1,0,0,1) {
            @Override
            public boolean update(float delta, float lastDelta, float lastDelta2) {
                return false;
            }
        });
        boolean expResult = true;
        boolean result = behaviour.isActive(client);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testIsActiveIgnore() {
        System.out.println("isActive");
        preys.add(new Prey(game,1,300,10,1,Color.GREEN,1,0,0,1) {
            @Override
            public boolean update(float delta, float lastDelta, float lastDelta2) {
                return false;
            }
        });
        boolean expResult = false;
        boolean result = behaviour.isActive(client);
        assertEquals(expResult, result);        
    }

    @Test
    public void testPriority() {
        double expected = 1.0;
        double actual = behaviour.priority();
        assertEquals(expected, actual, 0.0F);
    }
    
    @Test
    public void testString() {
        String expected = "PreyBehaviour";
        String actual = behaviour.toString();
        assertNotEquals(expected,actual);
    }
    
    @Test
    public void testBoosting() {
        preys.add(new Prey(game,1,5,5,1,Color.GREEN,1,0,0,1) {
            @Override
            public boolean update(float delta, float lastDelta, float lastDelta2) {
                return false;
            }
        });
        behaviour.isActive(client);
        boolean expected = true;
        boolean actual = behaviour.isBoosting();
        assertEquals(expected,actual);
    }
    
    @Test
    public void testNotBoosting() {
        preys.add(new Prey(game,1,270,105,1,Color.GREEN,1,0,0,1) {
            @Override
            public boolean update(float delta, float lastDelta, float lastDelta2) {
                return false;
            }
        });
        behaviour.isActive(client);
        boolean expected = true;
        boolean actual = behaviour.isBoosting();
        assertEquals(expected,actual);
    }
    
    @Test
    public void testAngle() {
        preys.add(new Prey(game,1,50,50,1,Color.GREEN,1,0,0,1) {
            @Override
            public boolean update(float delta, float lastDelta, float lastDelta2) {
                return false;
            }
        });
        behaviour.isActive(client);
        double expected = 0.7853981633974483;
        double actual = behaviour.targetAngle();
        assertEquals(expected,actual,0.0F);
    }

    /**
     * Test of targetAngle method, of class PreyBehaviour.
     */
    @Test
    public void testTargetAngle() {
        System.out.println("targetAngle");
        PreyBehaviour instance = new PreyBehaviour();
        double expResult = 0.0;
        double result = instance.targetAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of isBoosting method, of class PreyBehaviour.
     */
    @Test
    public void testIsBoosting() {
        System.out.println("isBoosting");
        PreyBehaviour instance = new PreyBehaviour();
        boolean expResult = true;
        boolean result = instance.isBoosting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of toString method, of class PreyBehaviour.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PreyBehaviour instance = new PreyBehaviour();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of behaviourName method, of class PreyBehaviour.
     */
    @Test
    public void testBehaviourName() {
        System.out.println("behaviourName");
        PreyBehaviour instance = new PreyBehaviour();
        instance.behaviourName();
        // TODO review the generated test code and remove the default call to fail.
         
    }
}

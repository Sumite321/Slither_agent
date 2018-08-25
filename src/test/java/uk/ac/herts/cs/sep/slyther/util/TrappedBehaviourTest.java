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
import net.gegy1000.slyther.game.Game;
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
public class TrappedBehaviourTest {
    
    private SlytherClient client;
    private Game game;
    private List<Snake<?>> snakes;
    private TrappedBehaviour instance;
    private ClientSnake snake,snake2,snake3,snake4,snake5;
    
    public TrappedBehaviourTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ClientSnake player = mock(ClientSnake.class);
        snake = mock(ClientSnake.class);
        snake2 = mock(ClientSnake.class);
        snake3 = mock(ClientSnake.class);
        snake4 = mock(ClientSnake.class);
        snake5 = mock(ClientSnake.class);
        client=mock(SlytherClient.class);
        client.player=player;
        game=mock(Game.class);
        when(game.getSectorSize()).thenReturn(1000);
        when(client.getGameRadius()).thenReturn(1000);
        
        player.points=new ArrayList<>();
        player.points.add(new SnakePoint(game,10,10));
        
        snake.points=new ArrayList<>();
        snake.points.add(new SnakePoint(game,10,10));
        
        snake2.points=new ArrayList<>();
        snake2.points.add(new SnakePoint(game,0,0));
        snake2.points.add(new SnakePoint(game,100,100));
        snake3.points=new ArrayList<>();
        snake3.points.add(new SnakePoint(game,0,3));
        
        snake4.points=new ArrayList<>();
        snake4.points.add(new SnakePoint(game,600,600));
        
        snake5.points=new ArrayList<>();
        snake5.points.add(new SnakePoint(game,0,0));
        
        snakes = new ArrayList<>();
        when(client.getSnakes()).thenReturn((snakes));
        
        client.player.id = 2;
        snake.id = 3;
        snake2.id=5;
        
        instance = new TrappedBehaviour();
    }
    
    
    @After
    public void tearDown() {
    }

    /**
     * Test of targetAngle method, of class PreyBehaviour.
     */
    @Test
    public void testTargetAngle() {
        System.out.println("targetAngle");
        double expResult = 0.0;
        double result = instance.targetAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of priority method, of class PreyBehaviour.
     */
    @Test
    public void testPriority() {
        System.out.println("priority");
        double expResult = 0.0;
        double result = instance.priority();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBoosting method, of class PreyBehaviour.
     */
    @Test
    public void testIsBoosting() {
        System.out.println("isBoosting");
        boolean expResult = false;
        boolean result = instance.isBoosting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class PreyBehaviour.
     */
 @Test
    public void testIsActive() {
            System.out.println("isActive");
            System.out.println(client.getSnakes());
       snakes.add(snake);
        boolean expResult = true;
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
    }
    
    @Test
    public void testIsActive2() {
            System.out.println("isActive");
            System.out.println(client.getSnakes());
        snakes.add(snake2);
        boolean expResult = false;
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
    }
    
    @Test
    public void testIsActive3() {
       System.out.println("isActive");
       
       
       //instance.distance_3 = 2000;
       snakes.add(snake);
        boolean expResult = false;
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
 
    }
    
        @Test
    public void testIsActive4() {
       System.out.println("isActive");
       
       client.player.id = 5;
       snake.id = 5;
       snakes.add(snake);
        boolean expResult = false;
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
    }
    
    @Test
    public void testIsActive5() {
       System.out.println("isActive");
       
       client.player.id = 5;
       snake.id = 6;
       snakes.add(snake);
        boolean expResult = false;
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
    }
       
    @Test
    public void testIsActive6() {
       System.out.println("isActive6");
       
       client.player.id = 5;
       snake.id = 6;
       
       snake5.id = 5;
       
       snakes.add(snake);
       snakes.add(snake4);
       snakes.add(snake2);
       snakes.add(snake5);
       for(Snake s:snakes){
           instance.isActive(client);
           System.out.println("HERE:" + s.points);
       } 
        boolean expResult = true;
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class TrappedBehaviour.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TrappedBehaviour instance = new TrappedBehaviour();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of behaviourName method, of class TrappedBehaviour.
     */
    @Test
    public void testBehaviourName() {
        System.out.println("behaviourName");
        TrappedBehaviour instance = new TrappedBehaviour();
        instance.behaviourName();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

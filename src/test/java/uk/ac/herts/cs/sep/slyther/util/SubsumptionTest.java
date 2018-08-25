/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import java.util.ArrayList;
import java.util.Date;
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
public class SubsumptionTest {
    
    private SlytherClient client;
    private Game game;
    private List<Snake<?>> snakes;
    private Subsumption instance;
    private ClientSnake snake,snake2;
    
    public SubsumptionTest() {
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
        client=mock(SlytherClient.class);
        client.player=player;
        game=mock(Game.class);
        when(game.getSectorSize()).thenReturn(1000);
        when(client.getGameRadius()).thenReturn(1000);
        
        player.points=new ArrayList<>();
        player.points.add(new SnakePoint(game,10,10));
        
        snake.points=new ArrayList<>();
        snake.points.add(new SnakePoint(game,12,12));
        
        snake2.points=new ArrayList<>();
        snake2.points.add(new SnakePoint(game,1200,1200));
        
        
        snakes = new ArrayList<>();
        when(client.getSnakes()).thenReturn((snakes));
        
        client.player.id = 2;
        snake.id = 3;
        snake2.id=5;
        
        instance = new Subsumption();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBestBehaviour method, of class Subsumption.
     */
    @Test
    public void testGetBestBehaviour() {
        System.out.println("getBestBehaviour");
       
        SnakeBehaviour expResult = null;
        SnakeBehaviour result = instance.getBestBehaviour(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Subsumption.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        instance.update(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTargetAngle method, of class Subsumption.
     */
    @Test
    public void testGetTargetAngle() {
        System.out.println("getTargetAngle");
        
        List<SnakeBehaviour> behaviours = new ArrayList<>();
        TrappedBehaviour trapB = new TrappedBehaviour();	
        behaviours.add(trapB);
        Subsumption instance = new Subsumption(behaviours);
        float expResult = 0.0F;
        float result = instance.getTargetAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

        @Test
    public void testGetTargetAngle1() {
        System.out.println("getTargetAngle");
        
        float expResult = 0.0F;
        
        instance.update(client);
        float result = instance.getTargetAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of shouldAccelerate method, of class Subsumption.
     */
    @Test
    public void testShouldAccelerate() {
        System.out.println("shouldAccelerate");
        Subsumption instance = new Subsumption();
        boolean expResult = false;
        boolean result = instance.shouldAccelerate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetTargetAngle2() {
        System.out.println("getTargetAngle");
        
        float expResult = 0.0F;
        instance.getBestBehaviour(client);
        instance.update(client);
        float result = instance.getTargetAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
       @Test
    public void testGetTargetAngle3() {
        System.out.println("getTargetAngle");
        
        float expResult = 0.0F;
        instance.getBestBehaviour(client);
        client.player.dead = true;
        instance.update(client);
        float result = instance.getTargetAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
           @Test
    public void testGetTargetAngle4() {
        System.out.println("getTargetAngle");
        
        float expResult = 0.0F;
        instance.getBestBehaviour(client);
        client.player.dead = true;
        instance.start = true;
        instance.update(client);
        float result = instance.getTargetAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartTime method, of class Subsumption.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        Subsumption instance = new Subsumption();
        instance.setStartTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartTime method, of class Subsumption.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Subsumption instance = new Subsumption();
        Date expResult = null;
        Date result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

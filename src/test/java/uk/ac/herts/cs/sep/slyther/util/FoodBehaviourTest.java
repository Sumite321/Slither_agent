/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import net.gegy1000.slyther.client.SlytherClient;
import java.util.ArrayList;
import java.util.List;
import net.gegy1000.slyther.game.Color;
import net.gegy1000.slyther.game.Game;
import net.gegy1000.slyther.game.entity.Food;
import net.gegy1000.slyther.client.game.entity.ClientSnake;
import net.gegy1000.slyther.game.entity.SnakePoint;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.powermock.api.mockito.PowerMockito.*;
/**
 *
 * @author admin
 */
public class FoodBehaviourTest {
    
    private FoodBehaviour instance;
    private List<Food<?>> foods;
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
        player.points.add(new SnakePoint(game,-2,-44));
        foods=new ArrayList<>();
        when(client.getFoods()).thenReturn((foods));
        instance=new FoodBehaviour();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsActive1() {
        System.out.println("isActive");
        System.out.println(client.player.points);
        foods.add(new Food(game,10,10,1,true,Color.GREEN) {
        
        public boolean update(float delta, float lastDelta, float lastDelta2) {
            return false;
        }
        });
        boolean expResult = true;
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
    }
    
    @Test
        public void testIsActive2() {
        System.out.println("isActive");
       
        boolean expResult = false;
        
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
            System.out.println(instance.targetAngle());
    }
        
            
    @Test
        public void testIsActive3() {
        System.out.println("isActive");
       
        boolean expResult = false;
        for(Food f: client.getFoods()){
        f.eaten = true;
        }
        boolean result = instance.isActive(client);
            assertEquals(expResult, result);
            System.out.println(instance.targetAngle());
    }
    @Test
    public void testTargetAngle() {
        System.out.println("targetAngle1");
        foods.add(new Food(game,10,10,1,true,Color.GREEN) {

        public boolean update(float delta, float lastDelta, float lastDelta2) {
            return false;
        }
        });
        
        double expAngle = Math.PI/4;
        boolean result = instance.isActive(client);
        double actual = instance.targetAngle();
            assertEquals(expAngle,actual,0.0001);
    }
    
        @Test
    public void testTargetAngle1() {
        System.out.println("targetAngle1");
        foods.add(new Food(game,0,10,1,true,Color.GREEN) {

        public boolean update(float delta, float lastDelta, float lastDelta2) {
            return false;
        }
        });
        
                foods.add(new Food(game,700,700,1,true,Color.GREEN) {

        public boolean update(float delta, float lastDelta, float lastDelta2) {
            return false;
        }
        });
                
                        foods.add(new Food(game,0,3,1,true,Color.GREEN) {

        public boolean update(float delta, float lastDelta, float lastDelta2) {
            return false;
        }
        });
                        for(Food f:foods){
                        instance.isActive(client);
                        }
                        
        double expAngle = Math.PI/2;
        //boolean result = instance.isActive(client);
        double actual = instance.targetAngle();
            assertEquals(expAngle,actual,0.0001);
    }
    
           @Test
    public void testTargetAngle3() {
        System.out.println("targetAngle1");
      
        
        boolean result = false;
        boolean actual = instance.isActive(client);
            assertEquals(result,actual);
    }
    
    @Test
    public void testPriority() {
        System.out.println("priority");
        FoodBehaviour instance = new FoodBehaviour();
        double expResult = 2.0;
        double result = instance.priority();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testIsBoosting() {
        System.out.println("isBoosting");
        FoodBehaviour  instance = new FoodBehaviour ();
        boolean expResult = false;
        boolean result = instance.isBoosting();
        assertEquals(expResult, result);
    }

    /**
     * Test of isActive method, of class FoodBehaviour.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        SlytherClient client = null;
        FoodBehaviour instance = new FoodBehaviour();
        boolean expResult = false;
        boolean result = instance.isActive(client);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class FoodBehaviour.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FoodBehaviour instance = new FoodBehaviour();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of behaviourName method, of class FoodBehaviour.
     */
    @Test
    public void testBehaviourName() {
        System.out.println("behaviourName");
        FoodBehaviour instance = new FoodBehaviour();
        instance.behaviourName();
    }
    
}
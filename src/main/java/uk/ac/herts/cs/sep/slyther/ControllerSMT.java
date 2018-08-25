/*
package uk.ac.herts.cs.sep.slyther;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.client.controller.IController;
import net.gegy1000.slyther.client.game.entity.ClientSnake;
import net.gegy1000.slyther.game.entity.Food;
import uk.ac.herts.cs.sep.slyther.util.PointMaths;


import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import uk.ac.herts.cs.sep.slyther.util.AvoidBehaviour;
import uk.ac.herts.cs.sep.slyther.util.FoodBehaviour;
import uk.ac.herts.cs.sep.slyther.util.PointMaths;

public class ControllerSMT implements IController {
    private float targetAngle;
    private float angleToPrey;
    private float targetAtMe;
    private PointMaths pm = new PointMaths();

    private boolean accelerating;
    private boolean foodhunt ;
    public int lastMouseX;
    public int lastMouseY;
    
    private FoodBehaviour foodBehaviour ;
    private AvoidBehaviour avoidBehaviour ;

    @Override
    public void update(SlytherClient client) {
        

       // get the food 
        ClientSnake player = client.player;
        
        // set player as true
        client.player.isPlayer = true;
        
        // initialise behaviour
        foodBehaviour = new FoodBehaviour(client);
        avoidBehaviour = new AvoidBehaviour(client);
        
        // activate FOOD HUNT & AVOID
        foodBehaviour.activate();
        //targetAngle = (float) foodBehaviour.targetAngle();
        avoidBehaviour.activate();
        
        // if there are obstacles in the way, avoid
        if(avoidBehaviour.isBoosting()){
            targetAngle = (float) avoidBehaviour.targetAngle();
        }else{ // if no obstacles, eat food
            targetAngle = (float) foodBehaviour.targetAngle();
        }
        
        accelerating = Mouse.isButtonDown(0) || Mouse.isButtonDown(1);
                
    }

    @Override
    public float getTargetAngle() {
        return targetAngle;
    }

    @Override
    public boolean shouldAccelerate() {
        return accelerating;
    }
}
*/
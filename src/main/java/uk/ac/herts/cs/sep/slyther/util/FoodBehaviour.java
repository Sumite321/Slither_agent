/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import java.awt.Point;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.game.Game;

/**
 *
 * @author comqdhb
 */
public class FoodBehaviour extends SnakeBehaviour {

    private boolean isBoosting;
    private PointMaths pm = new PointMaths();
    
    public FoodBehaviour(){
    }
    
    @Override
    public double targetAngle() {
        return (double) angle;
    }

    @Override
    public double priority() {
        return 2.0;
    }

    @Override
    public boolean isBoosting() {
        return isBoosting;
        }

    @Override
    public boolean isActive(SlytherClient client) {
        active = false;
    client.getFoods().forEach((f) -> {   
         
                //set as active
                
                //get the coordinates of the food               
                float foodX= f.posX;
                float foodY = f.posY;
                
                
                // get my coordinates
                float myX = client.player.posX;
                float myY = client.player.posY;
                
                
                // convert to Point
                Point.Double myLocation = new Point.Double((double) myX,(double) myY);
                Point.Double gameSnakeHead = new Point.Double((double) foodX,(double) foodY);
                
                // calculate the distance between food and snake head
                double distance_2 = pm.distance(myLocation, gameSnakeHead);

                // if the distance bellow X, eat
                if(distance_2 >5 && distance_2 < 250){
                    active = true;
                    isBoosting = true;
                    angle = pm.angle(myLocation, gameSnakeHead);
                }
            
        });
        return active;
    }    

    @Override
    public String toString() {
        return "FoodBehaviour{" + "priority=" + ", isBoosting=" + isBoosting + ", pm=" + pm + '}';
    }
    
    public void behaviourName(){
        System.out.println("Avoid");
    }
    
}

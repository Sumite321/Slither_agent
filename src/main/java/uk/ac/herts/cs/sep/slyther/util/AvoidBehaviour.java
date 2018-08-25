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
public class AvoidBehaviour extends SnakeBehaviour {

    private double angleToPrey;
    private boolean isBoosting = false;
    private PointMaths pm = new PointMaths();
    
    
    public AvoidBehaviour(){
        
    }

    @Override
    public double targetAngle() {
        
        return (double) angle;       
    }
        
    @Override
    public double priority() {
        return 4.0;
        }

    @Override
    public boolean isBoosting() {
        return isBoosting;    
    }

    @Override
    public boolean isActive(SlytherClient client) {
        
        client.getSnakes().forEach((s) ->{
            if(client.player.id != s.id){
                     
                // snakes position
                float SnakeX= s.prevPosX;
                float SnakeY = s.prevPosY;
                
                //angle 
                //angleToPrey = client.getAngleTo(SnakeX,SnakeY);
                
                // our position 
                float myX = client.player.posX;
                float myY = client.player.posY;
                Point.Double myLocation = new Point.Double((double) myX,(double) myY);
                Point.Double gameSnakeHead = new Point.Double((double) SnakeX,(double) SnakeY);

                //distance to snake from us
                //double distance = Math.hypot(myX - SnakeX, myY-SnakeY);
                double distance_2 = pm.distance(myLocation, gameSnakeHead);
                //System.out.println(distance);
             // if the snake comes near
             /*
               if(((distance_2 > 0) && (distance_2 <150))){
                    targetAngle += 1;
                }*/
             s.points.forEach((sp)->{

                float SnakeP = sp.posX;
                float SnakeP2 = sp.posY;
                double distance_3 = pm.distance(myLocation, sp);
                double pointDistance = Math.hypot(myX - SnakeP, myY-SnakeP2);
         
                
                if(((distance_3 > 5) && (distance_3 < 500))){
                    active = true;
                    angleToPrey = pm.angle(myLocation, sp);
                    if(angleToPrey <0 ){angle = angleToPrey + (float) Math.PI;}
                    else if (angleToPrey >=0){angle = angleToPrey - (float) Math.PI;}
                    //System.out.println(String.format("from pm %.1f, name: %s on right", distance_3,s.name));
                                    //System.out.println(angleToPrey);
                }else{
                active = false;
                }
            });
            }
    }); 
    return active;
    }

    @Override
    public String toString() {
        return "AvoidBehaviour{" + "angleToPrey=" + angleToPrey + ", isBoosting=" + isBoosting + ", pm=" + pm + '}';
    }
    
    public void behaviourName(){
        System.out.println("Avoid");
    }
    
    
}

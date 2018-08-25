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
public class NullBehaviour extends SnakeBehaviour {

    private PointMaths pm = new PointMaths();

    
    public NullBehaviour(){
    }
    

    @Override
    public double targetAngle() {
      
        return angle;
        
    }

    @Override
    public double priority() {
    return 0.0;
    }

    @Override
    public boolean isBoosting() {
    return false;
    }

    @Override
    public boolean isActive(SlytherClient client) {
        active = false;
        
            // the center
            float centerX = client.getGameRadius();
            float centerY = client.getGameRadius();
            Point.Double center = new Point.Double((double) centerX,(double) centerY);
        
        
            // our position 
            float myX = client.player.posX;
            float myY = client.player.posY;
            Point.Double myLocation = new Point.Double((double) myX,(double) myY);
        
            
            // angle to center
            
            angle = pm.angle(myLocation,center);
    return true;
        }

    @Override
    public String toString() {
        return "NullBehaviour{" + "pm=" + pm + '}';
    }
    
    public void behaviourName(){
        System.out.println("Null");
    }

}

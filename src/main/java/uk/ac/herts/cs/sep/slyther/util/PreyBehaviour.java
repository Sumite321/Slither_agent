/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import java.awt.Point;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.game.Game;
import net.gegy1000.slyther.game.entity.Prey;

/**
 *
 * @author comqdhb
 */
public class PreyBehaviour extends SnakeBehaviour {

    private PointMaths pm = new PointMaths();
    
    
    public PreyBehaviour(){
    }
  

   @Override
    public double targetAngle() {
        return (double) angle;
    }

    @Override
    public double priority() {
    return 1.0;
    }

    @Override
    public boolean isBoosting() {
    return true;
    }

    @Override
    public boolean isActive(SlytherClient client) {
        
    
        for(Prey prey: client.getPreys()) {
            
            // our position 
            float myX = client.player.posX;
            float myY = client.player.posY;
                
            Point.Double myLocation = new Point.Double((double) myX,(double) myY);
            Point.Double prey_pos = new Point.Double(prey.posX, prey.posY);
            double distance = pm.distance(prey_pos, myLocation);
            if(distance < 275) {
                angle = pm.angle(prey_pos, myLocation);
                angle += Math.PI;
                active = true; // SPEED!
    }
    
}
        return active;
    }

    @Override
    public String toString() {
        return "PreyBehaviour{" + "angleToPrey=" + ", pm=" + pm + ", distance_3=" + '}';
    }
    
    public void behaviourName(){
        System.out.println("Prey");
    }

}

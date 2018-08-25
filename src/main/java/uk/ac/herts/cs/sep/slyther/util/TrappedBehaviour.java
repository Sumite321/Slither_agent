/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import com.google.common.collect.Iterables;
import java.awt.Point;
import java.util.List;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.game.Game;
import net.gegy1000.slyther.game.entity.Snake;
import net.gegy1000.slyther.game.entity.SnakePoint;
import uk.ac.herts.cs.sep.slyther.QuickHull;

/**
 *
 * @author comqdhb
 */
public class TrappedBehaviour extends SnakeBehaviour {
        
    private PointMaths pm = new PointMaths();
    public TrappedBehaviour(){
    }

   @Override
    public double targetAngle() {
        return angle;
    }

    @Override
    public double priority() {
    return 3.0;
    }

    @Override
    public boolean isBoosting() {
    return false;
    }

    @Override
    public boolean isActive(SlytherClient client) {
        for(Snake snake: client.getSnakes()) {
            if(snake.id != client.player.id) {

            float myX = client.player.posX;
            float myY = client.player.posY;
            Point.Double myLocation = new Point.Double((double) myX,(double) myY);
                
            QuickHull hull = new QuickHull(snake);
            
            if(hull.hull.contains(myLocation)) {
               SnakePoint getTail = Iterables.getLast( (List<SnakePoint>)snake.points );
               double distance = pm.distance(getTail, myLocation);
               //System.out.println("this has run");
               if(distance > 0 && distance < 500 ) {
                   
                    active = true;
                    angle = pm.angle(getTail, myLocation);
                    
                    System.out.println("Trapped activated! Distance " + distance);
               }
            }
            }
        }
        return active;
    }

    @Override
    public String toString() {
        return "TrappedBehaviour{" + "pm=" + pm + '}';
    }
    
    public void behaviourName(){
        System.out.println("Trapped");
    }
}

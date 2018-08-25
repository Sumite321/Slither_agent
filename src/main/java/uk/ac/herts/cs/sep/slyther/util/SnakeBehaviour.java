/*

* NOTE: the behaviour no longer retains a copy of the client.

* it is the responsibility of the (Subsumption) controller to pass a copy of the SlytherClient to the behaviour when the isActive method is called
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package uk.ac.herts.cs.sep.slyther.util;

import net.gegy1000.slyther.client.SlytherClient;

/**
*
* @author comqdhb
*/
public abstract class SnakeBehaviour implements Comparable<SnakeBehaviour> {

protected double angle;
protected boolean active;

public SnakeBehaviour() {
angle=0.0;
active=false;
}

public abstract boolean isActive(SlytherClient client);

public double targetAngle(){return angle;};

public abstract double priority();

public abstract boolean isBoosting();

@Override
public int compareTo(SnakeBehaviour other) {
return ((Double) priority()).compareTo(other.priority());
}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import java.awt.Point;

/**
 *
 * @author comqdhb
 */
public class PointMaths {
    
    
    public double angle(Point.Double p1,Point.Double p2){
        double angle = Math.atan2(p2.y-p1.y,p2.x-p1.x);
        return angle;
    }
    
    public double distance(Point.Double p1,Point.Double p2){
        
        double distance = p1.distance(p2);
        return distance;
    }
    
}

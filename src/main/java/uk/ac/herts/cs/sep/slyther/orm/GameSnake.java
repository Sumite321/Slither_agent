/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.orm;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.Table;

/**
 *
 * @author liban
 */
@Entity
@Table( name = "APP.GAMESNAKE" )
public class GameSnake implements Serializable  {
    
    
    private @Id @GeneratedValue(strategy=GenerationType.AUTO) int id;
    private String name; 
    private int length;

    public int getId() {
        return id;
    }

    public int getSnakeLength() {
        return length;
    }

    public void setSnakeLength(int snakeLength) {
        this.length = snakeLength;
    }

    
    public void setId(int id) {
        this.id = id;
    }    
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
}
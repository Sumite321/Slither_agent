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
 * @author ahmedabdirahman
 */
@Entity
@Table( name = "APP.PLAYERSNAKE" )
public class PlayerSnake implements Serializable {
    
    private @Id @GeneratedValue(strategy=GenerationType.AUTO) int id;
    private float alivefor;
    private int controller_id; 
    private String date;
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
 
    public float getAlivefor() {
        return alivefor;
    }

    public void setAlivefor(float alivefor) {
        this.alivefor = alivefor;
    }

    public int getController_id() {
        return controller_id;
    }

    public void setController_id(int controller_id) {
        this.controller_id = controller_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
 
    
    // this needs to be completed by Ahmed
     public String toString(){
        return "uk.ac.herts.cs.sep.slyther.orm.PlayerSnake_Entity[id=" +"]"; 
    }
   
}
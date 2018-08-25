/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.util;

import com.sun.glass.ui.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.SwingWorker;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.client.controller.Controller;
import net.gegy1000.slyther.client.controller.IController;
import net.gegy1000.slyther.client.game.entity.ClientSnake;
import net.gegy1000.slyther.game.entity.Snake;
import net.gegy1000.slyther.util.Log;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.reflections.Reflections;
import uk.ac.herts.cs.sep.slyther.orm.DB;
import uk.ac.herts.cs.sep.slyther.orm.SnakesListBean;

/**
 *
 * @author comqdhb
 */
public class Subsumption implements IController{
    
    private List<SnakeBehaviour> behaviours;
    private float targetAngle;
    private boolean accelerating;
    private SnakeBehaviour foodB;
    private SnakeBehaviour avoidB;
    private SnakeBehaviour trapB;
    private SnakeBehaviour nullB;
    private SnakeBehaviour preyB;
    private Date date;
    public boolean start = false;
    private SnakesListBean showBean;
    private DB db;
    //private SlytherClient c;

    public Subsumption(List<SnakeBehaviour> s){
        behaviours=s;
    }
    
    
    
    public Subsumption(){
        
        behaviours=new ArrayList<>();
        foodB = new FoodBehaviour();
        avoidB = new AvoidBehaviour();
        nullB = new NullBehaviour();
        preyB = new PreyBehaviour();
        trapB = new TrappedBehaviour();
        
        behaviours.add(foodB);
        behaviours.add(avoidB);
        behaviours.add(trapB);
        behaviours.add(nullB);
        behaviours.add(preyB);
        
        //updateFrame(c);
        showBean = new SnakesListBean();
        setStartTime();
        
        
    }
    
    public SnakeBehaviour getBestBehaviour(SlytherClient client){
        
        SnakeBehaviour toRun = nullB;
        
        for(SnakeBehaviour b:behaviours){
            // run the highest priority
            if(b.isActive(client) && toRun.compareTo(b)< 0){
                //System.out.println(b.toString());
            toRun = b;
            }
        
        
    }
        return toRun;
    }
 
    @Override
    public void update(SlytherClient client) {
        if(client.player.getLength()==10){start = false;}
        //System.out.println(client.player.getLength());
        //System.out.println(start);
        targetAngle = (float) getBestBehaviour(client).targetAngle();
        //updateFrame(client);
        // runs only when player dead
          if(client.player.dead){
            if(!start){
                start = true;
                
                //Display.destroy();
                updateFrame(client);
 
            }
        }
        
        /*
        accelerating = Mouse.isButtonDown(0) || Mouse.isButtonDown(1);
        System.out.print(accelerating);*/
                
    }
    
    public void setStartTime(){
        date = new Date();
    }
    
    public Date getStartTime(){
        return date;
    }

    private void updateFrame(SlytherClient client) {
         
         // draws the Frame, empty
        SwingWorker worker = new SwingWorker() {
            
            String body = "";

            @Override
            protected Object doInBackground() throws Exception {
                boolean started = false;
                if(!started){
                db = new DB(client,getStartTime()); 
                
                db.connectToDB(); // connect
 
                db.addGameSnakeToDB(); // add all the snakes
                db.addPlayerToDB(); 
                db.close();
                started = true;// add all the players
                }
                System.out.println(("@@@@@@@@@@@@@@@@@@@@@@@********** NOW RUNNING"));
                return null;
            }

            //called on event dispatch thread
            public void done() {
                db.connectToDB();
                db.readAllGameSnakes();
                db.readPlayerSnakes();
                showBean.setGameSnake(db.getAllSnakes());
                showBean.setPlayerSnake(db.getPlayerSnake());
                db.close();
              if(!showBean.running){showBean.drawFrame();}
                else{showBean.updateTables();
                  showBean.repaint();}
            }

        };

        worker.execute();
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

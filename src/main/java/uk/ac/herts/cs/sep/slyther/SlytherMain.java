/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.UIManager;
import static net.gegy1000.slyther.client.ClientMain.loadNatives;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.game.entity.Entity;
import net.gegy1000.slyther.game.entity.Food;
import net.gegy1000.slyther.game.entity.Sector;
import net.gegy1000.slyther.game.entity.Snake;
import net.gegy1000.slyther.game.entity.SnakePoint;
import net.gegy1000.slyther.client.controller.Controller;
import net.gegy1000.slyther.client.controller.DefaultController;
import net.gegy1000.slyther.client.controller.IController;
import uk.ac.herts.cs.sep.slyther.orm.DB;
import uk.ac.herts.cs.sep.slyther.orm.SnakesListBean;
import uk.ac.herts.cs.sep.slyther.util.Subsumption;



/**
 *
 * @author admin
 */
public class SlytherMain {
    
private SlytherClient client;

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        loadNatives();
        SlytherMain main = new SlytherMain();  
        
        
    }

    public SlytherMain(){
        //SnakesListBean bean = new SnakesListBean();
        client = new SlytherClient();
         
        IController sub = new Subsumption();
        client.setController(sub);
        client.run(); 
        
        
}
}
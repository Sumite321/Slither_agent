/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.orm;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.gegy1000.slyther.client.SlytherClient;
import static org.eclipse.persistence.expressions.ExpressionMath.add;
import static org.lwjgl.opengl.Display.setTitle;

/**
 *
 * @author admin
 */
public class SnakesListBean extends JFrame implements Serializable{


    private JTable leftTable;
    private JTable rightTable;
    private JFrame frame;
    //private DB db;
    private ArrayList<GameSnake> allSnakes = new ArrayList<>();
    private ArrayList<PlayerSnake> playerSnake = new ArrayList<>();
    public boolean running = false;


    public SnakesListBean() {
    }
    
    public void drawFrame(){
        //db = new DB();
        //db.connectToDB();
        
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Snake Information");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.setLayout(new GridBagLayout());
       
        leftTable = new JTable(new TableModelGame());
        rightTable = new JTable(new TableModelPlayer());

        setupTable(leftTable);
        setupTable(rightTable);

        updateTables();

        JPanel pnlActions = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy++;

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        frame.add(new JLabel("Game Snakes"), gbc);
        gbc.gridx++;
        frame.add(new JPanel(), gbc);
        gbc.gridx++;
        frame.add(new JLabel("Player Snakes"), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.weighty++;
        gbc.fill = GridBagConstraints.BOTH;

        frame.add(new JScrollPane(leftTable), gbc);
        gbc.gridx++;
        frame.add(pnlActions, gbc);
        gbc.gridx++;
        frame.add(new JScrollPane(rightTable), gbc);

        frame.setSize(400, 600);
        running = true;
    } 
        
       
    

    protected void populatePlayer(TableModelPlayer model) {
        
        model.setRowCount(0);
        for(PlayerSnake gs : playerSnake){
            model.addRow(new Object[]{gs.getName(), gs.getSnakeLength(),gs.getController_id(),gs.getDate(),gs.getAlivefor()});
        }
    }
    
       protected void populateSnakes(TableModelGame model) {
        model.setRowCount(0);
        for(GameSnake gs : allSnakes){
            model.addRow(new Object[]{gs.getName(), gs.getSnakeLength()});
        }
    }
       
     public void setGameSnake(ArrayList<GameSnake> snakes){
     
        this.allSnakes = snakes;
     }
     
      public ArrayList<GameSnake> getGameSnake(){
     
        return allSnakes;
     }
       
           public void setPlayerSnake(ArrayList<PlayerSnake> snakes){
     
        this.playerSnake = snakes;
     }
     
      public  ArrayList<PlayerSnake> getPlayerSnake(){
     
        return playerSnake;
     }
      
    protected void setupTable(JTable table) {

        table.setFillsViewportHeight(true);
        table.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
    }
    
    public void updateTables(){
        populateSnakes((TableModelGame) leftTable.getModel());
        populatePlayer((TableModelPlayer) rightTable.getModel());
        
    }
}

    


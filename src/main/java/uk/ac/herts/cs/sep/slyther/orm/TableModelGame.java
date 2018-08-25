package uk.ac.herts.cs.sep.slyther.orm;


import javax.swing.table.DefaultTableModel;
import net.gegy1000.slyther.game.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ash_a
 */
public class TableModelGame  extends DefaultTableModel{
    
    
    public TableModelGame() {

        addColumn("Snake Name");
        addColumn("Length");

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        Class clazz = String.class;

        switch (columnIndex) {

            case 1:
                clazz = Color.class;
                break;
            default:
                clazz = Color.class;
        }

        return clazz;

    }

    
}

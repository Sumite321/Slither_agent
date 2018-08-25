/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.orm;

import javax.swing.table.DefaultTableModel;
import net.gegy1000.slyther.game.Color;

/**
 *
 * @author ash_a
 */
public class TableModelPlayer extends DefaultTableModel{
    
    public TableModelPlayer() {

        addColumn("Snake Name");
        addColumn("Length");
        addColumn("Controller ID");
        addColumn("Date/Time");
        addColumn("Alive");


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

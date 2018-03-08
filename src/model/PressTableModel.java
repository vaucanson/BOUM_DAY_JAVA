/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PressManager;
import entity.Press;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author badaroux
 */
public class PressTableModel extends AbstractTableModel {

    private ArrayList<Press> pressList = PressManager.fillNonBusyPressList();
    private ArrayList<String> titlePressList = new ArrayList<>();

    public PressTableModel() {
        titlePressList.add("Presse");
        titlePressList.add("Etat");
       
       
    }

    @Override
    public int getRowCount() {
       return pressList.size();
    }

    @Override
    public int getColumnCount() {
        return titlePressList.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object o = null;
        Press p = pressList.get(row);
        
        switch (column)
        {
            case 0 :
                o = p.getId();
                   break;
            case 1 : 
                String s;
                if (p.GetisFree() == true)
                {
                   s = "disponible"; 
                }
                else 
                {
                    s = "indisponible";
                }
                o = s;
                break;
        }
        return o;
    }

}

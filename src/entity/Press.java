/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.swing.JOptionPane;

/**
 *
 * @author badaroux
 */
public class Press {
    
    private int id;
    private boolean isFree;

    public Press(int i) 
    {
        if (!setId(i))
        {
            JOptionPane.showMessageDialog(null, "Erreur : l'ID de la presse doit être un nombre positif.");
        }
        setIsFree(true);
    }
    
        public int getId() {
        return id;
    }

    public boolean setId(int id) {
        boolean ok = false;
        if (id >= 0)
        {
            this.id = id;
            ok = true;
        }
        return ok;
    }

        public boolean GetisFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }
    
    @Override
    public String toString() {
        return "Presse numéro " + id;
    }
}

package entity;

import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author mattar
 */
public class Batch {
    private short id;
    private Date date;
    private short piecesNumber;
    private short state;
    private short press;
    private String model;
    
    public short getId() {
        return id;
    }
    
    public boolean setId(short id) {
        boolean ok = false;
        if (id > 0)
        {
            this.id = id;
            ok = true;
        }
        return ok;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public short getPiecesNumber() {
        return piecesNumber;
    }
    
    public boolean setPiecesNumber(short piecesNumber) {
        boolean ok = false;
        if (piecesNumber > 0)
        {
            this.piecesNumber = piecesNumber;
            ok = true;
        }
        return ok;
    }
    
    public short getState() {
        return state;
    }
    
    public boolean setState(short state) {
        boolean ok = false;
        if ((state > 0) && (state < 5))
        {
            this.state = state;
            ok = true;
        }
        return ok;
    }
    
    public short getPress() {
        return press;
    }
    
    public boolean setPress(short press) {
        boolean ok = false;
        
        if (press > 0)
        {
            this.press = press;
            ok = true;
        }
        return ok;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    
    public Batch (short id, Date date, short pn, short state, short press, String model)
    {
        this.date = date;
        this.model = model;
        
        if (!setPiecesNumber(pn))
        {
            JOptionPane.showMessageDialog(null, "Erreur : le nombre de pièces doit être positif.");
        }
        else if (!setState(state))
        {
            JOptionPane.showMessageDialog(null, "Erreur : l'état du lot doit être compris entre 1 et 4.");
        }
        else if (!setPress(press))
        {
            JOptionPane.showMessageDialog(null, "Erreur : l'ID de la presse doit être positif.");
        }
        else if (!setId(id))
        {
            JOptionPane.showMessageDialog(null, "Erreur : l'ID du lot doit être positif.");
        }
        
        
    }
    
    @Override
    public String toString() {
        return "Lot numero : " + id + " || " + piecesNumber + " pièces de modèle " + model;
    }
    
}

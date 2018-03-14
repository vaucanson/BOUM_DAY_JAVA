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
    private Model model;
    
    public short getId() {
        return id;
    }
    
    private void setId(short id) {
        
        this.id = id;
    }
    
    public Date getDate() {
        return date;
    }
    
    private void setDate(Date date) {
        this.date = date;
    }
    
    public short getPiecesNumber() {
        return piecesNumber;
    }
    
    private void setPiecesNumber(short piecesNumber) {
        
        this.piecesNumber = piecesNumber;
    }
    
    public int getState() {
        return dao.BatchManager.getState(this);
    }
    
    
    public boolean setState(short state) {
        boolean ok = false;
        if ((state > 0) && (state < 5))
        {
            dao.BatchManager.setStateFour(this);
            this.state = state;
            ok = true;
            
        }
        return ok;
    }
    public short getPress()
    {
        return press;
    }
    
    private void setPress(short press)
    {
        this.press = press;
    }
    
    public Model getModel() {
        return model;
    }
    
    private void setModel(Model model) {
        this.model = model;
    }
    
    
    public Batch (short id, Date date, short pn, short state, short press, Model model)
    {
        setId(id);
        setDate(date);
        setModel(model);
        setPiecesNumber(pn);
        setPress(press);
        setState(state);
        
        
    }
    
    
    
    @Override
    public String toString() {
        return "Lot numero : " + id + " || " + piecesNumber + " pièces de modèle " + model.getName();
    }
    
}

package entity;

import java.sql.Date;

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

    public void setId(short id) {
        this.id = id;
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

    public void setPiecesNumber(short piecesNumber) {
        this.piecesNumber = piecesNumber;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public short getPress() {
        return press;
    }

    public void setPress(short press) {
        this.press = press;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    
    public Batch (short id, Date date, short pn, short state, short press, Model model)
    {
        this.id = id;
        this.date = date;
        this.piecesNumber = pn;
        this.state = state;
        this.press = press;
        this.model = model;
        
    }


    
    @Override
    public String toString() {
        return "lot numero : " + id + ", " + piecesNumber + " pièces de modèle " + model  + ". Etat : " + state;
    }
    
}

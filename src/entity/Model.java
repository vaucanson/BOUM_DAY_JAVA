package entity;

import javax.swing.JOptionPane;

/**
 *
 * @author boilleau
 */
public class Model {
    
    private String name; // le nom, qui est l'identifiant
    private float diameter; // le diamètre théorique
    
    // le minimum de stock autorisé pour les pièces de ce modèle, par catégorie
    private int smallLimit; // en catégorie petit
    private int mediumLimit;  // en catégorie moyen
    private int bigLimit;  // en catégorie grand

    
     /**
     * Constructeur à limites
     */
    public Model(String name, float diameter, int smallLimit, int mediumLimit, int bigLimit)
    {
        setName(name);
        setDiameter(diameter);
        setSmallLimit(smallLimit);
        setMediumLimit(mediumLimit);
        setBigLimit(bigLimit);
    }
    
    
    
    public int getSmallLimit() {
        return smallLimit;
    }

    public int getMediumLimit() {
        return mediumLimit;
    }

    public int getBigLimit() {
        return bigLimit;
    }

     /**
     * Constructeur
     */
    public Model(String name, float diameter)
    {
        // appel du constructeur à limites avec des valeurs à 0
        this(name, diameter, 0, 0, 0);
    }
    
   
    
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public float getDiameter() {
        return diameter;
    }

    private void setDiameter(Float diameter) {
       this.diameter = diameter;
    }

    private void setSmallLimit(int smallLimit) {
        this.smallLimit = smallLimit;
    }

    private void setMediumLimit(int mediumLimit) {
        this.mediumLimit = mediumLimit;
    }

    private void setBigLimit(int bigLimit) {
        this.bigLimit = bigLimit;
    }
    
    
   
}

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
        
        if (!setDiameter(diameter))
        {
            JOptionPane.showMessageDialog(null, "Erreur dans la saisie du diamètre (nombre négatif).");
        }        
        else if (!setSmallLimit(smallLimit))
        {
            JOptionPane.showMessageDialog(null, "Erreur : la limite doit être un nombre positif.");
        }
        else if (!setMediumLimit(mediumLimit))
        {
            JOptionPane.showMessageDialog(null, "Erreur : la limite doit être un nombre positif.");
        }
        else if (!setBigLimit(bigLimit))
        {
            JOptionPane.showMessageDialog(null, "Erreur : la limite doit être un nombre positif.");
        }
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

    private boolean setDiameter(Float diameter) {
        boolean ok = false;
        if (diameter > 0)
        {        
            this.diameter = diameter;
            ok = true;
        }
        
       return ok;
    }

    private boolean setSmallLimit(int smallLimit) {
        boolean ok = false;
        if (smallLimit >= 0)
        {
            this.smallLimit = smallLimit;
            ok = true;
        }
       
        return ok;
    }

    private boolean setMediumLimit(int mediumLimit) {
         boolean ok = false;
        if (mediumLimit >= 0)
        {
            this.mediumLimit = mediumLimit;
            ok = true;
        }
       
        return ok;
    }

    private boolean setBigLimit(int bigLimit) {
         boolean ok = false;
        if (bigLimit >= 0)
        {
             this.bigLimit = bigLimit;
             ok = true;
        }
       return ok;
    }
    
    
   
}

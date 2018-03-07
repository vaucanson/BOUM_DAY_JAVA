package entity;

/**
 *
 * @author boilleau
 */
public class Model {
    
    private String name; // le nom, qui est l'identifiant
    private Float diameter; // le diamètre théorique

     /**
     * Constructeur
     */
    public Model(String name, float diameter)
    {
        setName(name);
        setDiameter(diameter);
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }
    
   
}

package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import tool.Connexion;

/**
 *
 * @author boilleau
 */
public abstract class CategoryManager 
{
    
    /**
     * get les tolérances mini et maxi d'une catégorie
     * @param name le nom de la catégorie
     * @return un tableau de deux floats, le premier étant la tolérance mini et le deuxième la tolérance maxi
     */
    public static float[] getTolerance(String name)
    {
        float[] tolerance = new float[2];
        
        try
        {
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("SELECT MINTOLERANCE, MAXTOLERANCE FROM CATEGORY WHERE NAME = '" + name + "'");
                if (rs.next())
                {
                    tolerance[0] = rs.getFloat(1);
                    tolerance[1] = rs.getFloat(2);
                }
                st.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }

        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return tolerance;
    }
    
    
    /**
     * Change les tolérances d'une catégorie donnée
     * @param name
     * @param min
     * @param max 
     */
    public static void changeTolerance(String name, float min, float max)
    {
        // ça ne sert à rien de changer les tolérances de waste.
        if (name != "WASTE")
        {
        try
        {
            Connection c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                CallableStatement cs = c.prepareCall("{?=call changeTolerance (?,?,?,?)}");
                
                cs.setString(2, name);
                cs.setFloat(3, min);
                cs.setFloat(4, max);
                
                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(5, java.sql.Types.VARCHAR);
                
                cs.execute();
                
                int ret = cs.getInt(1);
                String msg = cs.getString(5);
                
                if (ret == 0)
                {
                    System.out.println(msg);
                }
                else
                {
                    
                }
                
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Erreur  : Veuillez ne mettre qu'un seul chiffre avant la virgule.");
                e.printStackTrace();
                
            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        
                    }
                }
            }
        } catch (SQLException ex) 
        {
           ex.printStackTrace();
        }
        }
    }
}

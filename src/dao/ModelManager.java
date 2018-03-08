package dao;

import entity.Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.Connexion;

/**
 *
 * @author boilleau
 */
public abstract class ModelManager 
{
    private ModelManager()
    {
        
    }
    
    /**
     * permet de retrouver un objet Model à partir de son nom, via une requête BDD
     * @param name  est le nom de l'objet Model recherché
     */
      public static Model getModel(String name)
    {
        Model mod = null;
        
        try
        {
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM MODEL WHERE  NAME = '" + name + "' ");
                
                if (rs.next())
                {
                   mod = new Model(rs.getString(1), rs.getInt(2));
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return mod;
    }
    
      
      
      
      // permet de remplir une liste de modèles
      public static ArrayList<Model> load()
      {
          ArrayList<Model> mList = new ArrayList<>();
          
        
        
        try
        {
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM MODEL ORDER BY NAME ");
                
                while (rs.next())
                {
                   mList.add(new Model(rs.getString(1), rs.getFloat(2)));
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally 
            {
                if (c != null) 
                {
                    try 
                    {
                        c.close();
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                        
                    }
                }
            }
        }
        catch(SQLException ex)
        {
           ex.printStackTrace();
        }
        return mList;
      }
      
}
    


package dao;

import entity.Model;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tool.Connexion;

/**
 *
 * @author boilleau
 */
public abstract class ModelManager 
{
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
      public static ArrayList<Model> loadActive()
      {
          ArrayList<Model> mList = new ArrayList<>();
          
        
        
        try
        {
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM MODEL where active = 1 ORDER BY NAME ");
                
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
      
      // permet de remplir une liste de modèles
      public static ArrayList<Model> loadAll()
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
      
      /** 
       * ajoute un modèle en bdd
       * @param model le modèle à ajouter
       * @return un code de retour entier. 
       * @see ModelManager.insert
       */
      public static int add(Model model)
      {
          return ModelManager.insert(model.getName(), model.getDiameter(), model.getSmallLimit(), model.getMediumLimit(), model.getBigLimit());
      }
      
      
    /**
     * Ajoute un modèle en bdd
     * @param name
     * @param diameter
     * @param smallMin
     * @param middleMin
     * @param bigMin
     * @return un code de retour entier.
     * 0 : tout est bien
     * 1 : erreur en bdd : les paramètres ne sont pas au bon format
     * 2 : erreur en bdd : // pas implémenté
     * 3 : erreur en bdd : erreur lors de l'insertion
     * 4 : erreur java
     */
     private static int insert(String name, Float diameter, int smallMin, int middleMin, int bigMin)
     {
        int ret = 4; // le code de retour
        try
        {
            Connection c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                CallableStatement cs = c.prepareCall("{?=call addModel (?, ?, ?, ?, ?, ?)}");
                
                cs.setString(2, name);
                cs.setFloat(3, diameter);
                cs.setInt(4, smallMin);
                cs.setInt(5, middleMin);
                cs.setInt(6, bigMin);
                
                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(7, java.sql.Types.VARCHAR);
                
                cs.execute();
                
                ret = cs.getInt(1);
                String msg = cs.getString(7);
                System.out.println(String.format("code retour : %d | message : %s", ret, msg));
                
                // si le retour n'est pas bon, on affiche un message d'erreur à l'utilisateur
                if (ret != 0)
                {
                    JOptionPane.showMessageDialog(null, msg, "titre", JOptionPane.ERROR_MESSAGE, null);
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            } 
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        return ret;
    }

     /**
      * Supprime en bdd le modèle donné
      * @param model
      * @return un code de retour entier.
      * 0 : tout est bien
      * 1 : erreur en bdd : le nom fourni n'est pas au bon format
      * 2 : erreur en bdd : le nom fourni n'existe pas
      * 3 : erreur en bdd : erreur lors de la suppression
      * 4 : erreur java
      */
    public static int delete(Model model) 
     {
        int ret = 4;   // le code de retour
        
        try
        {
            Connection c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                CallableStatement cs = c.prepareCall("{?=call removeModel (?, ?)}");
                
                cs.setString(2, model.getName());;
                
                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(3, java.sql.Types.VARCHAR);
                
                cs.execute();
                
                ret = cs.getInt(1);
                String msg = cs.getString(3);
                System.out.println(String.format("code retour : %d | message : %s", ret, msg));
                
                // si le retour n'est pas bon, on affiche un message d'erreur à l'utilisateur
                if (ret != 0)
                {
                    JOptionPane.showMessageDialog(null, msg, "titre", JOptionPane.ERROR_MESSAGE, null);
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            } 
            finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        return ret;
    }
      
      
}
    


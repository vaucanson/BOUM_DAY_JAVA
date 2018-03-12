package dao;

import entity.Category;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tool.Connexion;
import view.frame.MainFrame;
import view.panel.ApplicationToleranceManagementPanel;

/**
 *
 * @author mattar
 */
public abstract class CategoryManagerOld {
    
//    private CategoryManagerOld()
//    {
//        
//    }
//    
//    /**
//     *  permet de renvoyer un objet Category grace à une requete BDD à partir du nom
//     * @param name  est le nom de la catégorie recherchée
//     * @return      renvoie un objet Category
//     */
//    
//    public static Category getCategory(String name)
//    {
//       Category myCat = null;
//       
//       try
//        {
//            Connection c;
//            c = Connexion.getInstance("badaroux", "badaroux");
//            
//            try
//            {
//                Statement st = c.createStatement();
//                
//                ResultSet rs = st.executeQuery("SELECT * FROM CATEGORY WHERE NAME = '" + name + "'");
//                
//                if (rs.next())
//                {
//                   myCat = new Category(rs.getString(1), rs.getFloat(2), rs.getFloat(3));
//                }
//                st.close();
//            }
//            catch(Exception ex)
//            {
//                ex.printStackTrace();
//            }
//          
//        }
//        catch(SQLException ex)
//        {
//       
//            ex.printStackTrace();
//        }
//        return myCat;
//    }
//    
//    /**
//     *  renvoie une ArrayList d'objets Category, à partir d'une requete BDD
//     */
//    public static ArrayList<Category> load()
//    {
//        ArrayList<Category> cList = new ArrayList<>();
//        
//        try
//        {
//            Connection c;
//            c = Connexion.getInstance("badaroux", "badaroux");
//            
//            try
//            {
//                Statement st = c.createStatement();
//                
//                ResultSet rs = st.executeQuery("SELECT * FROM CATEGORY ORDER BY NAME ");
//                
//                while (rs.next())
//                {
//                   cList.add(new Category(rs.getString(1), rs.getFloat(2), rs.getFloat(3)));
//                }
//                st.close();
//            }
//            catch(Exception ex)
//            {
//                ex.printStackTrace();
//            }
//            finally 
//            {
//                if (c != null) 
//                {
//                    try 
//                    {
//                        c.close();
//                    } 
//                    catch (Exception e) 
//                    {
//                        e.printStackTrace();
//                        
//                    }
//                }
//            }
//        }
//        catch(SQLException ex)
//        {
//          
//            ex.printStackTrace();
//        }
//        return cList;
//    }
//    
//                  
//    
//    /*
//        permet de retrouver l'intervalle de tolérance minimal et maximal pour une catégorie donnée
//        @param name est le nom de la catégorie (petit, moyen, grand)
//    */
//    public static float[] getTolerance(String name)
//    {
//        
//        float[] tolerance = new float[2];
//        
//        try
//        {
//            
//            Connection c;
//            c = Connexion.getInstance("badaroux", "badaroux");
//            
//            try
//            {
//                Statement st = c.createStatement();
//                
//                ResultSet rs = st.executeQuery("SELECT MINTOLERANCE, MAXTOLERANCE FROM CATEGORY WHERE NAME = '" + name + "'");
//               
//                
//                if (rs.next())
//                {
//                    tolerance[0] = rs.getFloat(1);
//                    tolerance[1] = rs.getFloat(2);
//                }
//                st.close();
//            }
//            catch (SQLException ex)
//            {
//                ex.printStackTrace();
//            }
//            finally
//            {
//                try
//                {
//                    c.close();
//                }
//                catch (SQLException ex)
//                {
//                    ex.printStackTrace();
//                }
//            }
//        }
//        catch(SQLException ex)
//        {
//            ex.printStackTrace();
//        }
//        
//        
//        return tolerance;
//    }
//    
//    public static void changeTolerance(String model, float min, float max)
//    {
//        try
//        {
//            Connection c = Connexion.getInstance("badaroux", "badaroux");
//            
//            try
//            {
//                CallableStatement cs = c.prepareCall("{?=call changeTolerance (?,?,?,?)}");
//                
//                cs.setString(2, model);
//                cs.setFloat(3, min);
//                cs.setFloat(4, max);
//                
//                cs.registerOutParameter(1, java.sql.Types.INTEGER);
//                cs.registerOutParameter(5, java.sql.Types.VARCHAR);
//                
//                cs.execute();
//                
//                int ret = cs.getInt(1);
//                String msg = cs.getString(5);
//                
//                if (ret == 0)
//                {
//                    System.out.println(msg);
//                }
//                else
//                {
//                    
//                }
//                
//            } catch (Exception e) 
//            {
//                JOptionPane.showMessageDialog(null, "Erreur  : Veuillez ne mettre qu'un seul chiffre avant la virgule.");
//                e.printStackTrace();
//                
//                
//            } finally {
//                if (c != null) {
//                    try {
//                        c.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        
//                    }
//                }
//            }
//            
//        } catch (SQLException ex) {
//            
//           ex.printStackTrace();
//            
//        }
//    }
}
    


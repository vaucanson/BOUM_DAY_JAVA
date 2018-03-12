
package dao;

import entity.Category;
import entity.Model;
import entity.Stock;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tool.Connexion;

/**
 *
 * @author mattar
 */
public class StockManager {
    
    private StockManager()
    {
        
    }
    
    /*
    *   cette fonction rempli une ArrayList d'objets Stock (pour la WorkShopPanel)
    *   il fait appel à une fonction View (StockUnderLimit) de la base de donnée
    *   si une quantité d'un modèle et d'une catégorie est en dessous du seuil limite, alors la colonne ISLIMITREACHED indique 1, sinon 0
    */
    public static ArrayList<Stock> loadStockUnderLimit()
    {
        ArrayList<Stock> liste = new ArrayList<>();
        try
        {
            
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM STOCKUNDERLIMIT WHERE ISLIMITREACHED = 1");
                
                while (rs.next())
                {
                    if (rs.getInt(5) == 1)
                    {
                        Category cat = CategoryManager.getCategory(rs.getString(2));
                        Model mod = ModelManager.getModel(rs.getString(1));
                        liste.add(new Stock(mod, cat, rs.getInt(3), rs.getInt(4)));
                    }
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return liste;
    }
    
    /**
     * Renvoie la liste des noms de colonnes
     * @return un tableau de chaînes
     */
    public static ArrayList<String> colonnesStock()
    {
        ArrayList<String> listStock = new ArrayList<String>();
        
        try
        {
            
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM STOCKUNDERLIMIT");
                ResultSetMetaData rsmd = rs.getMetaData();
                
                for (int i = 1; i <= rsmd.getColumnCount()-1; i++)
                {
                    listStock.add(rsmd.getColumnName(i));
                }
                st.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        
        return listStock;
    }
    
    /**
     * Crée un tableau de Stocks contenant tous les stocks
     * @return un ArrayList de Stocks
     */
    public static ArrayList<Stock> getAllStocks()
    {
        ArrayList<Stock> retour = new ArrayList();
        try
        {
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM STOCKUNDERLIMIT");
                ResultSetMetaData rsmd = rs.getMetaData();
                
                while (rs.next())
                {   
                    Model model = ModelManager.getModel(rs.getString(1));
                    Category category = CategoryManager.getCategory(rs.getString(2));
                    int quantity = rs.getInt(3);
                    int limit = rs.getInt(4);
                    
                    Stock stock = new Stock(model, category, quantity, limit);
                    retour.add(stock);
                }
                st.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return retour;
    }
    
    /*
        cette fonction permet de renvoyer un nombre de pièces en stock pour un modèle donné et une catégorie donnée
        @param model est le modèle ciblé par la ComboBox de la WorkShopPanel
        @param category est la catégorie ciblée par la ComboBox de la WorkShopPanel
    */
    public static int getQuantity(String model, String category)
    {        
        int quantity = 0;
        
        try
        {
            
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT QUANTITY FROM STOCK WHERE MODEL = '" + model + "' AND CATEGORY = '" + category + "'");
               
                
                if (rs.next())
                {
                    quantity = rs.getInt(1);
                }
                st.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        
        return quantity;
    }
    
    /*
        cette fonction permet de renvoyer le seuil limite de pièces pour un modèle donné et une catégorie donnée
        @param model est le modèle ciblé par la ComboBox de la WorkShopPanel
        @param category est la catégorie ciblée par la ComboBox de la WorkShopPanel
    */
    public static int getLimit(String model, String category)
    {
        
        int limit = 0;
        
        try
        {
            
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT LIMIT FROM STOCK WHERE MODEL = '" + model + "' AND CATEGORY = '" + category + "'");
               
                
                if (rs.next())
                {
                    limit = rs.getInt(1);
                }
                st.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        
        return limit;
    }
    
    
    public static void changeLimit(String model, String category, int limit)
    {
        try
        {
            Connection c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                CallableStatement cs = c.prepareCall("{?=call changeLimit (?,?,?,?)}");
                
                cs.setString(2, model);
                cs.setString(3, category);
                cs.setInt(4, limit);
                
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
                
            } catch (Exception e) {
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
            
        } catch (SQLException ex) {
            
        
           ex.printStackTrace();
            
        }
    }
    
    
    /**
     * Modifie la quantité d'un stock en base de données
     * @param model
     * @param category
     * @param quantity 
     */
    public static void changeQuantity(String model, String category, int quantity)
    {
        try
        {
            Connection c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                CallableStatement cs = c.prepareCall("{?=call addCrate (?,?,?,?)}");
                
                cs.setString(2, category);
                cs.setString(3, model);
                cs.setInt(4, quantity);
                
                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(5, java.sql.Types.VARCHAR);
                
                cs.execute();
                
                int ret = cs.getInt(1);
                String msg = cs.getString(5);
                
                if (ret == 0)
                {
                    System.out.println(msg);
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
    }
    
}


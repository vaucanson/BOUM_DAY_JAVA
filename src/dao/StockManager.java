
package dao;

import entity.Category;
import entity.Model;
import entity.Stock;
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
                        liste.add(new Stock(mod, cat, rs.getInt(4), rs.getInt(3)));
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
}



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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
}


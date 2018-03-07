package tool;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe permettant la connexion à une base de données. Elle implémente le
 * pattern Singleton, car on n'a pas besoin de l'instancier plusieurs fois. Donc
 * il n'y a pas de constructeur public, on doit récupérer l'unique instance par
 * le biais de la méthode getInstance().
 * 
 * @author boilleau
 *
 */
public class Connexion
{
	// la seule instance qui pourra exister. Utilisée par le pattern Singleton
	private static Connexion instance;

	// la connexion
	private static Connection conn;


	/**
	 * Constructeur. Il est nécessaire qu'il soit privé pour le pattern
	 * Singleton
	 */
	private Connexion(String user, String pwd) throws SQLServerException
	{
		SQLServerDataSource dataSource = new SQLServerDataSource();
		dataSource.setURL("jdbc:sqlserver://serveur-sql2017");
		dataSource.setDatabaseName("BOUM_DAY");
		dataSource.setUser(user);
		dataSource.setPassword(pwd);

                this.conn = dataSource.getConnection();
                
//		try
//		{
//			this.conn = dataSource.getConnection();
//		}
//		catch (Exception e)
//		{
//			System.out.println("Connexion échouée !\r> " + e.getMessage());
//		}
	}

	/**
	 * Renvoie l'instance, en la créant avec les user et mdp donnés si elle n'existe pas
	 * 
	 * @return
	 */
	public static Connection getInstance(String user, String pwd) throws SQLServerException, SQLException
	{
            if (instance == null || conn.isClosed())
            {
                    synchronized (Connexion.class)
                    {
                            if (instance == null || conn.isClosed())
                                    instance = new Connexion(user, pwd);
                    }
            }

		return conn;
	}
        
        /**
	 * Renvoie l'instance, ou null si elle n'existe pas encore ou si la connexion est close.
	 * 
	 * @return
	 */
	public static Connection getInstance() throws SQLException
	{
            Connection retour = null;
            if (instance == null || conn.isClosed())
            {
                // en vrai il faudra lancer une exception
                System.out.println("erreur de connexion : il faut re-renseigner les login et mot de passe");
            }
            else
            {
		retour = conn;  
            }
            return retour;
	}

	/**
	 * Ferme la connexion
	 */
	public static void close()
	{
		try
		{
			if (conn != null && !conn.isClosed())
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Interdit le clonage en déclenchant une exception sur une tentative de
	 * clonage
	 */
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}

/*package serveur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

public class FamilleDao {
	private final static String QUERY_FIND_ARTICLES = "SELECT * FROM article INNER JOIN famille ON article.famille = famille.id";
	
	
    public List<Article> findArticles() {

        List<Article> articles = new ArrayList<Article>();

        try 
		{
			String url = "jdbc:mysql://localhost:3306/projet_rmi";
		    String user = "root";
		    String passwd = "";

		    Connection conn = DriverManager.getConnection(url, user, passwd);
		    
		    System.out.println("Connexion effective !");  
		    
		    Statement stmt = conn.createStatement();
	        ResultSet rset = stmt.executeQuery(QUERY_FIND_ARTICLES);
	        
	        
	        
	        while ( rset.next() ) {
	        	System.out.println("test");
	            int id = rset.getInt("id");
	            String nom = rset.getString("nom");
	            int stock = rset.getInt("stock");
	            Integer familleid = rset.getInt("famille");
	            Famille f = new Famille();
	            double prix = rset.getDouble("prix");
	            Article a = new Article(id, stock, nom, f, prix);
	            //System.out.println(a.toString());
	            articles.add(a);
	        }
	        
	        rset.close();
	        stmt.close();
	        conn.close();
		           
		         
		} 
		catch (Exception e)
		{
		    e.printStackTrace();
		}      

        return articles;
    }
}
*/
package serveur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;
import java.sql.PreparedStatement;

public class ArticleDao {
	private final static String QUERY_FIND_ARTICLES = "SELECT a.nom AS nom, f.nom AS famille, a.stock AS stock, a.prix AS prix, a.id AS id FROM article a INNER JOIN famille f ON a.famille = f.id";
	private final static String QUERY_SEARCH_ARTICLES = "SELECT a.nom AS nom, f.nom AS famille, a.stock AS stock, a.prix AS prix, a.id AS id FROM article a INNER JOIN famille f ON a.famille = f.id WHERE a.nom LIKE '?";
	
	
    public List<Article> findArticles(String search) {

        List<Article> articles = new ArrayList<Article>();

        try 
		{
			String url = "jdbc:mysql://localhost:3306/projet_rmi";
		    String user = "root";
		    String passwd = "";

		    Connection conn = DriverManager.getConnection(url, user, passwd);
		    
		    System.out.println("Connexion effective !");  
		    
		    //Statement stmt = conn.createStatement();
	        //ResultSet rset = stmt.executeQuery(QUERY_FIND_ARTICLES);
	        
		    String recherche = search;
		    
		    recherche = recherche
		    	    .replace("!", "!!")
		    	    .replace("%", "!%")
		    	    .replace("_", "!_")
		    	    .replace("[", "![");
		    
		    PreparedStatement stmt = conn.prepareStatement("SELECT a.nom AS nom, f.nom AS famille, a.stock AS stock, a.prix AS prix, a.id AS id FROM article a INNER JOIN famille f ON a.famille = f.id WHERE a.nom LIKE ?");
		    stmt.setString(1, "%" + recherche + "%");
		    ResultSet rset = stmt.executeQuery();
	        
	        
	        while ( rset.next() ) {
	        	System.out.println("test");
	            int id = rset.getInt("id");
	            String nom = rset.getString("nom");
	            int stock = rset.getInt("stock");
	            String famille = rset.getString("famille");
	            double prix = rset.getDouble("prix");
	            Article a = new Article(id, stock, nom, famille, prix);
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

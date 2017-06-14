package serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import projetrmi.RMI;

public class RMIServer extends UnicastRemoteObject implements RMI {
	
	private static String URL = "";
	
	private ArticleDao adao = new ArticleDao();
	
	public RMIServer() throws RemoteException{
		super();
	}
	
	@Override
	public String getData(String text) throws RemoteException {
		text = "hi " + text;
		
		
		return text;
	}
	
	public List<Article> getListeArticles(String search) throws RemoteException {
		List<Article> articles = this.adao.findArticles(search);
		return articles;
	}
	
	
	public static void main(String args[]){
		try{
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("server", new RMIServer());
			System.out.println("Server started");
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}
}

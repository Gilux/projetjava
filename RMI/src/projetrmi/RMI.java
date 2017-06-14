package projetrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import serveur.Article;

public interface RMI extends Remote {
	public String getData(String text) throws RemoteException;
	
	public List<Article> getListeArticles(String search) throws RemoteException;
}
